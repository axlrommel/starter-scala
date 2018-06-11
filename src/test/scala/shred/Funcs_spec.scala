package shred

import org.scalatest.FlatSpec
import shred.domains.User

class Funcs_spec extends FlatSpec {

  val testUserSeq = Seq(
    User(11, "Nick", "Smith", false),
    User(89, "Ken", "Pratt", true),
    User(23, "Jack", "Sparrow", true)
  )

  it should "get last names in active users" in {
    val activeUsersLastName = MyUtil.activeLastNames(testUserSeq)
    assert(activeUsersLastName.length == 2)
    assert(activeUsersLastName(0) == "Pratt")
    assert(activeUsersLastName(1) == "Sparrow")
  }

  it should "add the ids" in {
    val sumIds = MyUtil.addIds(testUserSeq)
    assert(sumIds == 123)
  }

  it should "lowercase the first and last names" in {
    val usersLowerCased = MyUtil.lowerCaseNames(testUserSeq)
    assert(usersLowerCased.length == 3)
    assert(usersLowerCased(0).lastname == "smith")
    assert(usersLowerCased(1).firstname == "ken")
  }

  it should "check if all users are active" in {
    val usersActive = MyUtil.checkUserStatusAllActive(testUserSeq)
    assert(usersActive == false)
  }

  it should "check if any users are active" in {
    val usersActive = MyUtil.checkUserStatusAnyActive(testUserSeq)
    assert(usersActive == true)
  }
}
