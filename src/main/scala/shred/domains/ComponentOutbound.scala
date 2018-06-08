package shred.domains

case class ComponentOutbound(messageHeader: MessageHeader,
                             cname: String,
                             programType: String,
                             paymentMechanism: String,
                             minVolume: String,
                             tierType: String,
                             tierUnits: String,
                             calculateOn: String,
                             dealerTargetPercent: String,
                             growerTargetPercent: String,
                             pnls: List[Pnls],
                             tierRatesByDate: List[TierRatesByDate],
                             tierRatesByVolume: List[TierRatesByVolume],
                             gid: String)
