package shred

import org.json4s._
import org.json4s.jackson.JsonMethods._
import org.json4s.JsonDSL._
import org.json4s.jackson.Serialization.write
import org.json4s.jackson.Serialization.read
import org.scalatest.FlatSpec
import shred.domains._
import shred.mockedData._
import io.jvm.uuid._
import java.time._

class JSONExtract_spec extends FlatSpec {
  implicit val formats = DefaultFormats
  val sampleP = new SampleProgram()
  val sampleM = new SampleMessages()
  val utcZoneId = ZoneId.of("UTC")

  it should "make sure JSON is not null" in {
    val extractedProgram = sampleP.getSampleProgram().extract[Program]
    assert(extractedProgram != null)
  }

  it should "have 14 doaApprovers" in {

    val doaApprovers =
      (sampleP.getSampleProgram() \ "doaApprovers").extract[List[Approver]]
    assert(doaApprovers.length == 14)
  }

  it should "have 2 components" in {

    val components =
      (sampleP.getSampleProgram() \ "components").extract[List[Component]]
    assert(components.length == 2)
  }

  it should "have 1 scope" in {

    val scopes = (sampleP.getSampleProgram() \ "scopes").extract[List[Scope]]
    assert(scopes.length == 1)
  }

  it should "match original once scope is converted back to JSON," in {

    val qq = write(parse(
      """{"hub":"North America","country":"US","bisunit":"Regional Brands",
      "product":"Wheat","brand":"Kruger Seeds","gid":"37lq7luvrbj:1br7kvoh8"}""")
      .extract[Scope])
    val scopes = (sampleP.getSampleProgram() \ "scopes").extract[List[Scope]]
    for (scope <- scopes) {
      val tt = write(scope)
      assert(tt.toString() == qq.toString)
    }
  }

  it should " write back one scope at the time along with a message header" in {

    val scopes = (sampleP.getSampleProgram() \ "scopes").extract[List[Scope]]
    for (scope <- scopes) {
      val uuid = UUID(1, 2) //.random for random
      val zonedDateTime = ZonedDateTime.parse("2012-06-30T12:30:40Z[UTC]") //.now for right now
      val utcDateTime = zonedDateTime.withZoneSameInstant(utcZoneId)
      val timestamp = utcDateTime
        .toString()
        .substring(0, utcDateTime.toString().length - "[UTC]".length)
      val header = ("messageHeader" -> ("messageUUId" -> uuid.string) ~ ("messageTimestamp" -> timestamp) ~
        ("messageProducer" -> "Company360.DARTExtracter"))
      val currScope = parse(write(scope)) merge render(header)
      assert(write(currScope) == write(sampleM.getScopePlusHeader()))
    }
  }

  it should " write back one component at the time along with a message header" in {

    val components =
      (sampleP.getSampleProgram() \ "components").extract[List[Component]]
    for (component <- components) {
      val uuid = UUID(1, 2) //.random when not in test
      val zonedDateTime = ZonedDateTime.parse("2012-06-30T12:30:40Z[UTC]") //.now when not in test
      val utcDateTime = zonedDateTime.withZoneSameInstant(utcZoneId)
      val timestamp = utcDateTime
        .toString()
        .substring(0, utcDateTime.toString().length - "[UTC]".length)
      val header = ("messageHeader" -> ("messageUUId" -> uuid.string) ~ ("messageTimestamp" -> timestamp) ~
        ("messageProducer" -> "Company360.DARTExtracter"))
      val currComponent = parse(write(component)) merge render(header)
      println(write(component))
      assert(currComponent.extract[ComponentOutbound] != null)
      assert(
        write(currComponent) == write(sampleM.getComponent1PlusHeader()) ||
          write(currComponent) == write(sampleM.getComponent2PlusHeader()))
    }
  }

  it should "send the original program minus the components" in {

    val leftOver = sampleP.getSampleProgram() removeField {
      case JField("components", _) => true
      case _                       => false
    }
    assert(leftOver.extract[ProgramWOComponentOutbound] != null)
    assertThrows[MappingException] { leftOver.extract[Component] }
    assert(write(leftOver) == write(sampleM.getProgramWithoutComponents()))
  }
}
