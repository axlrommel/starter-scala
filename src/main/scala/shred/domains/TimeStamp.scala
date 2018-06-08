package shred.domains

case class TimeStamp(epoch: Double,
                     dateTime: String,
                     timeZone: String,
                     offsetmm: Int)
