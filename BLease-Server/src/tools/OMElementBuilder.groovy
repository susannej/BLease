package tools

import groovy.util.BuilderSupport  

import javax.xml.namespace.QName

import org.apache.axiom.om.OMAbstractFactory
import org.apache.axiom.om.OMElement
import org.apache.axiom.om.OMFactory
import org.apache.axiom.om.OMNamespace

/*
 * This code was found on the internet (stackoverflow.com), without any copyright notice in an answer
 * from a user named: Mark O'Connor
 * 
 * TODO: verify (and understand) this code against the codehaus.org example "Make a Builder" WEB-Site
 * http://groovy.codehaus.org/Make+a+builder
 * 
 */

class OMElementBuilder extends BuilderSupport {

    OMElement result
    String namespace

    OMElementBuilder(namespace) {
        this.namespace = namespace
    }

    def createNode(name) {
        createNode(name, null, null)
    }

    def createNode(name, value) {
        createNode(name, null, value)
    }

    def createNode(name, Map attributes) {
        createNode(name, attributes, null)
    }

    def createNode(name, Map attributes, value) {
		OMElement node
        OMFactory   fact = OMAbstractFactory.getOMFactory()
		if (namespace) {
			OMNamespace omNs = fact.createOMNamespace(namespace, "ns")
			node = fact.createOMElement(name, omNs)
		} else {
			node = fact.createOMElement(new QName(name))
		}

        if (value) {
            fact.createOMText(node, value)
        }

        node
    }

    void setParent(parent, child) {
        parent.addChild(child)
    }

    void nodeCompleted(parent, node) {
        if (!parent) {
            result = node
        }
    }
	
}