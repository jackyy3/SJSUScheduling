//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.23 at 09:00:35 PM PDT 
//


package org.sjsu.wfs.workflow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 * 				A work flow that contains all independent tasks.
 * 			
 * 
 * <p>Java class for TaskGroupWorkflow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaskGroupWorkflow">
 *   &lt;complexContent>
 *     &lt;extension base="{}Workflow">
 *       &lt;sequence>
 *       &lt;/sequence>
 *     &lt;/extension>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaskGroupWorkflow")
public class TaskGroupWorkflow
    extends Workflow
{

	public TaskGroupWorkflow() {
		super();
	}


}
