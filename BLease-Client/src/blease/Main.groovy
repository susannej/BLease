package blease

import wslite.soap.*

class Main {

	static void main(args) {
		def client = new SOAPClient('http://localhost:8080/axis2/services/BLeaseServer')
		def response = client.send(SOAPAction:'/GetDate') {
			body {
				GetMothersDay('xmlns':'http://www.27seconds.com/Holidays/US/Dates/') {
					year(2011)
				}
			}
		}
		println response
	}
	
}
