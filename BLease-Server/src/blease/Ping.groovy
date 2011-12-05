package blease

import javax.xml.stream.XMLStreamException
import javax.xml.namespace.QName

import org.apache.axiom.om.OMAbstractFactory
import org.apache.axiom.om.OMElement
import org.apache.axiom.om.OMFactory
import org.apache.axiom.om.OMNamespace

import tools.OMElementBuilder

import static java.text.DateFormat.*
import static java.util.Locale.*

import java.util.HashMap

class Ping {

    private HashMap map = new HashMap();

    private String namespace = "http://quickstart.samples/xsd";

    OMElement getDate(OMElement element) throws XMLStreamException {
		
		def xmlin = new XmlSlurper().parseText(element.toString());
		
		def xmlout = new OMElementBuilder()
		
		xmlout.getDateResponse() {
			currentDate( new Date() )
			germanLocale( getDateInstance(FULL, GERMAN).format(new Date()))
		}
		
		xmlout.result
    }

    void update(OMElement element) throws XMLStreamException {
        element.build();
        element.detach();

        OMElement symbolElement = element.getFirstChildWithName(new QName(namespace, "symbol"));
        String symbol = symbolElement.getText();

        OMElement priceElement = element.getFirstChildWithName(new QName(namespace, "price"));
        String price = priceElement.getText();

        map.put(symbol, new Double(price));
    }

}
