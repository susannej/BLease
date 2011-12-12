package blease

import groovy.util.logging.Log4j

import org.apache.axiom.om.OMElement

import tools.OMElementBuilder

import static java.text.DateFormat.*
import static java.util.Locale.*

@Log4j
class Ping {

    OMElement getDate(OMElement element) {
		
		log.trace "getDate Method"
		log.info element.toString()
		
		def xmlin = new XmlSlurper().parseText(element.toString())
		
		log.trace "step1"
		//def xmlout = new OMElementBuilder("http://example")
		def xmlout = new OMElementBuilder()
		log.trace "step2"
		xmlout.getDateResponse() {
			currentDate( new Date().toString() )
			germanLocale( getDateInstance(FULL, GERMAN).format(new Date()) )
		}
		log.trace "step3"
		
		xmlout.result
    }

    void update(OMElement element) {
		
		log.trace "update Method"
		log.info element.toString()

		def xmlin = new XmlSlurper().parseText(element.toString())

    }

}
