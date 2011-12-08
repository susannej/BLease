package blease

import org.apache.axiom.om.OMElement

import tools.OMElementBuilder

import static java.text.DateFormat.*
import static java.util.Locale.*


class Ping {

    OMElement getDate(OMElement element) {
		
		def xmlin = new XmlSlurper().parseText(element.toString())
		
		def xmlout = new OMElementBuilder()
		
		xmlout.getDateResponse() {
			currentDate( new Date() )
			germanLocale( getDateInstance(FULL, GERMAN).format(new Date()))
		}
		
		xmlout.result
    }

    void update(OMElement element) {
		
		def xmlin = new XmlSlurper().parseText(element.toString())

    }

}
