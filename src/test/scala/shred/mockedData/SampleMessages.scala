package shred.mockedData

import org.json4s._
import org.json4s.jackson.JsonMethods._

class SampleMessages() {
  def getScopePlusHeader() =
    parse(
      """{"hub":"North America","country":"US","bisunit":"Regional Brands",
    "product":"Wheat","brand":"Kruger Seeds","gid":"37lq7luvrbj:1br7kvoh8",
    "messageHeader":{"messageUUId":"00000000-0000-0001-0000-000000000002",
    "messageTimestamp":"2012-06-30T12:30:40Z","messageProducer":"Company360.DARTExtracter"}}""")

  def getComponent1PlusHeader() =
    parse(
      """{"cname":"Wheat Rate","programType":"Trade Incentive",
    "paymentMechanism":"","minVolume":"","tierType":"Date","tierUnits":"","calculateOn":"",
    "dealerTargetPercent":"43","growerTargetPercent":"57","pnls":[{"id":"Regional Brands/Wheat/Kruger Seeds",
    "accrualYear":"2018","expectedDisc":"4,000","gid":"13cg66lkf0t:1br7kvoh9","cgid":"5vf19h78eep:1br7kvoh9"}],
    "tierRatesByDate":[{"gid":"0","start":"2017-09-14","end":"2017-11-07","rate":"6",
    "cgid":"5vf19h78eep:1br7kvoh9"},{"gid":"7g2hblgoa91:1br7l9cmi","start":"2017-11-12","end":"2018-01-09",
    "rate":"5.1","cgid":"5vf19h78eep:1br7kvoh9"}],"tierRatesByVolume":[{"gid":"","min":"","max":"",
    "rate":"","cgid":"5vf19h78eep:1br7kvoh9"}],"gid":"5vf19h78eep:1br7kvoh9",
    "messageHeader":{"messageUUId":"00000000-0000-0001-0000-000000000002",
    "messageTimestamp":"2012-06-30T12:30:40Z","messageProducer":"Company360.DARTExtracter"}}""")

  def getComponent2PlusHeader() =
    parse(
      """{"cname":"Another Wheat Rate","programType":"Trade Incentive",
    "paymentMechanism":"","minVolume":"","tierType":"Volume","tierUnits":"","calculateOn":"",
    "dealerTargetPercent":"50","growerTargetPercent":"50","pnls":[{"id":"Regional Brands/Wheat/Kruger Seeds",
    "accrualYear":"2018","expectedDisc":"5,000","gid":"13cg66lkf0t:1br7kvoh9","cgid":"5vf19h78eep:1br7kvoh1"}],
    "tierRatesByDate":[{"gid":"","start":"","end":"","rate":"","cgid":"5vf19h78eep:1br7kvoh1"}],
    "tierRatesByVolume":[{"gid":"0","min":"1","max":"2","rate":"5","cgid":"5vf19h78eep:1br7kvoh1"}],
    "gid":"5vf19h78eep:1br7kvoh1","messageHeader":{"messageUUId":"00000000-0000-0001-0000-000000000002",
    "messageTimestamp":"2012-06-30T12:30:40Z","messageProducer":"Company360.DARTExtracter"}}""")

  def getProgramWithoutComponents() =
    parse(
      """{"messageHeader":{"messageUUId":"c30a0b90-a558-11e7-8fdd-a7189e1dc3b0",
    "messageTimestamp":"2017-09-29T20:57:10.601Z","messageProducer":"Company360.DARTExtracter"},"actionType":"U",
    "_id":"9c7c7adbf6a71c0760933caabe671d65","_rev":"35-b5b863da1f511cf021185bd4861daf8d","version":"1.0",
    "guid":"1lr6q1u9c2r:1br7kvoh8","id":"KJCTST21","pname":"Kevin Test 21","year":"2018","startDate":"2017-09-01",
    "endDate":"2018-08-31","scopes":[{"hub":"North America","country":"US","bisunit":"Regional Brands",
    "product":"Wheat","brand":"Kruger Seeds","gid":"37lq7luvrbj:1br7kvoh8"}],"season":"N/A",
    "criteriaDefinition":"Discretionary (Pls attach Authority Grid)","currency":"USD - US Dollar",
    "payee":"Farmer/Grower","marketingOwners":[{"name":{"id":"","display":""},"done":"","gid":""}],
    "financeOwners":[{"name":{"id":"","display":""},"done":"","gid":""}],"operationsOwners":[{"name":{"id":"",
    "display":""},"done":"","gid":""}],"paymentStartDate":"2017-09-21","accrual":"","ted":"400,000 USD",
    "budgetGreaterThanFiveMil":"","marketFundingCategory":"Grower Incentives (RLI 32203)",
    "liabilityClassification":"","rightOfSetOffParty":"","rightOfSetOffOwed":"","rightOfSetOffIntend":"",
    "rightOfSetOffLaw":"","rightOfSetOff":"No","currentStatus":"draft","deductClaims":"","payTax":"",
    "contractEarnings":"","signer":"","database":"programs","programTermGreaterThanTwelve":"No",
    "multiYearEarningsCriteria":"","newOrChangedProgram":"Yes","programWithPrepaymentTerms":"",
    "externalReportingApprovalRequired":"No","annualPrepayments":"","validity":false,"signerOther":"",
    "tedUSD":"$400,000 FY18 Budget Rate","dirty":0,"externalReportingApprovers":[{"_id":"","DOA":"",
    "department":"","velocity":{"id":"","firstName":"","lastName":""},"subWave":"","gid":""}],
    "doaApprovers":[{"_id":"AATTI1","DOA":"10,000,000","department":"Finance","velocity":{"id":"AATTI1",
    "firstName":"Amy","lastName":"Attias"},"subWave":"","gid":"AATTI1"},{"_id":"AGILL","DOA":"99,888,777,666",
    "department":"Sales","velocity":{"id":"AGILL","firstName":"Alex","lastName":"Gillette"},"subWave":"",
    "gid":"AGILL"},{"_id":"CADURA","DOA":"50,000,000","department":"Business","velocity":{"id":"CADURA",
    "firstName":"Charles","lastName":"Duran"},"subWave":"","gid":"CADURA"},{"_id":"CCHOI1","DOA":"100,000,000",
    "department":"Finance","velocity":{"id":"CCHOI1","firstName":"Cindy","lastName":"Choi"},"subWave":"",
    "gid":"CCHOI1"},{"_id":"DCOOL1","DOA":"1,000,000","department":"Operations","velocity":{"id":"DCOOL1",
    "firstName":"Danielle","lastName":"Cooley"},"subWave":"","gid":"DCOOL1"},{"_id":"JRFLAS",
    "DOA":"70,000,000","department":"Finance","velocity":{"id":"JRFLAS","firstName":"Jason",
    "lastName":"Flaspohler"},"subWave":"","gid":"JRFLAS"},{"_id":"KWDICK","DOA":"1,000,000",
    "department":"Marketing","velocity":{"id":"KWDICK","firstName":"Kyle","lastName":"Dick"},
    "subWave":"","gid":"KWDICK"},{"_id":"LEBRAVE","DOA":"1,000,000","department":"Finance",
    "velocity":{"id":"LEBRAVE","firstName":"Lisa","lastName":"Gutshall"},"subWave":"","gid":"LEBRAVE"},
    {"_id":"LSTIC1","DOA":"1,000,000","department":"Operations","velocity":{"id":"LSTIC1",
    "firstName":"Lucas","lastName":"Stice"},"subWave":"","gid":"LSTIC1"},{"_id":"MCHILT","DOA":"355,666",
    "department":"Marketing","velocity":{"id":"MCHILT","firstName":"Michael","lastName":"Hilton"},
    "subWave":"","gid":"MCHILT"},{"_id":"MHOLL3","DOA":"1,000,000","department":"Marketing",
    "velocity":{"id":"MHOLL3","firstName":"Michael","lastName":"Hollander"},"subWave":"",
    "gid":"MHOLL3"},{"_id":"NEARL","DOA":"1,000,000","department":"Finance","velocity":{"id":"NEARL",
    "firstName":"Nancy","lastName":"Early"},"subWave":"","gid":"NEARL"},{"_id":"RRKUHL",
    "DOA":"99,999,999","department":"Operations","velocity":{"id":"RRKUHL","firstName":"Ricardo",
    "lastName":"Kuhlenthal"},"subWave":"","gid":"RRKUHL"},{"_id":"SKIRK","DOA":"100,000",
    "department":"Operations","velocity":{"id":"SKIRK","firstName":"Sarah","lastName":"Kirk"},
    "subWave":"","gid":"SKIRK"}],"nonDoaApprovers":[{"_id":"KBROW5","DOA":"","department":"Legal",
    "velocity":{"id":"KBROW5","firstName":"Kieran","lastName":"Brown"},"subWave":"","gid":"KBROW5"},
    {"_id":"MGENO","DOA":"0","department":"Legal","velocity":{"id":"MGENO","firstName":"Michael",
    "lastName":"Genovese"},"subWave":"","gid":"MGENO"}],"meta":{"created":{"user":"KJCLAR3",
    "timestamp":{"epoch":1506716698883,"dateTime":"2017-09-29 20:24","timeZone":"GMT","offsetmm":0}},
    "lastEdited":{"user":"KJCLAR3","timestamp":{"epoch":1506718599598,"dateTime":"2017-09-29 20:56",
    "timeZone":"GMT","offsetmm":0}}}}""")
}
