package shred

import org.scalatest.FlatSpec

class Funcs_spec extends FlatSpec {

  case class User(id: Int, firstname: String, lastname: String, active: Boolean)

  val testUserSeq = Seq(
    User(11, "Nick", "Smith", false),
    User(89, "Ken", "Pratt", true),
    User(23, "Jack", "Sparrow", true)
  )
  def activeLastNames(us: Seq[User]) =
    us.filter(_.active)
      .map(_.lastname)
      .sortWith(_ < _)

  def addIds(us: Seq[User]) = us.map(_.id).reduceLeft(_ + _)

  def checkUserStatusAllActive(us: Seq[User]) =
    us.map(_.active).reduceLeft(_ && _)

  def checkUserStatusAnyActive(us: Seq[User]) =
    us.map(_.active).reduceLeft(_ || _)
    
  def lowerCaseNames(us: Seq[User]) =
    us.map(e =>
      User(e.id, e.firstname.toLowerCase(), e.lastname.toLowerCase(), e.active))

  it should "get last names in active users" in {
    val activeUsersLastName = activeLastNames(testUserSeq)
    assert(activeUsersLastName.length == 2)
    assert(activeUsersLastName(0) == "Pratt")
    assert(activeUsersLastName(1) == "Sparrow")
  }

  it should "add the ids" in {
    val sumIds = addIds(testUserSeq)
    assert(sumIds == 123)
  }

  it should "lowercase the first and last names" in {
    val usersLowerCased = lowerCaseNames(testUserSeq)
    assert(usersLowerCased.length == 3)
    assert(usersLowerCased(0).lastname == "smith")
    assert(usersLowerCased(1).firstname == "ken")
  }

  it should "check if all users are active" in {
    val usersActive = checkUserStatusAllActive(testUserSeq)
    assert(usersActive == false)
  }

  it should "check if any users are active" in {
    val usersActive = checkUserStatusAnyActive(testUserSeq)
    assert(usersActive == true)
  }
}
