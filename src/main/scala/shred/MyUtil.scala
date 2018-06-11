package shred;

import shred.domains.User

object MyUtil {
    
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
}