package shred.domains

case class MessageHeader(messageUUId: String,
                         messageTimestamp: String,
                         messageProducer: String)
