package shred

import org.json4s._
import org.json4s.jackson.JsonMethods._
import shred.domains.User

object Main {

  val testUserSeq = Seq(
    User(12, "Jack", "Daniels", false),
    User(24, "Kevin", "Low", true),
    User(34, "John", "Helm", true),
    User(41, "John", "Help", true)
  )

  def main(args: Array[String]): Unit = {

    val printVal =
      if (MyUtil.checkUserStatusAllActive(testUserSeq) == MyUtil
            .checkUserStatusAnyActive(testUserSeq))
        MyUtil.activeLastNames(testUserSeq)
      else MyUtil.lowerCaseNames(testUserSeq)

    println(printVal)
    println(MyUtil.addIds(testUserSeq))
  }

}
