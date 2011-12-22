package blease

import wslite.soap.*

class Main {

	static void main(args) {
		
		def client = new SOAPClient('http://localhost:8080/axis2/services/PingService')
		//def client = new SOAPClient('http://localhost:8080/axis2/services/StockQuoteService')
		def response = client.send(SOAPAction:'getDate') {
			body {
				getMothersDay('xmlns':'http://www.27seconds.com/Holidays/US/Dates/') {
					year(2011)
				}
			}
		}
		
		println response.getDateResponse.currentDate.text()
		println response.getDateResponse.germanLocale.text()
	}
	
}
