//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.29 at 12:03:59 AM PDT 
//


package org.sjsu.wfs.workflow;

import javax.xml.bind.JAXBElement;
import javax.xml.bind.annotation.XmlElementDecl;
import javax.xml.bind.annotation.XmlRegistry;
import javax.xml.namespace.QName;

import org.sjsu.wfs.workflow.ChainWorkflow;
import org.sjsu.wfs.workflow.CostModelDefinition;
import org.sjsu.wfs.workflow.Dependencies;
import org.sjsu.wfs.workflow.InputBinding;
import org.sjsu.wfs.workflow.OutputBinding;
import org.sjsu.wfs.workflow.SequentialWorkflow;
import org.sjsu.wfs.workflow.Task;
import org.sjsu.wfs.workflow.TaskContainer;
import org.sjsu.wfs.workflow.TaskGroupWorkflow;
import org.sjsu.wfs.workflow.Workflow;


/**
 * This object contains factory methods for each 
 * Java content interface and Java element interface 
 * generated in the org.sjsu.wfs.workflow.process package. 
 * <p>An ObjectFactory allows you to programatically 
 * construct new instances of the Java representation 
 * for XML content. The Java representation of XML 
 * content can consist of schema derived interfaces 
 * and classes representing the binding of schema 
 * type definitions, element declarations and model 
 * groups.  Factory methods for each of these are 
 * provided in this class.
 * 
 */
@XmlRegistry
public class ObjectFactory {

    private final static QName _Workflow_QNAME = new QName("", "workflow");

    /**
     * Create a new ObjectFactory that can be used to create new instances of schema derived classes for package: org.sjsu.wfs.workflow.process
     * 
     */
    public ObjectFactory() {
    }

    /**
     * Create an instance of {@link TaskContainer }
     * 
     */
    public TaskContainer createTaskContainer() {
        return new TaskContainer();
    }

    /**
     * Create an instance of {@link OutputBinding }
     * 
     */
    public OutputBinding createOutputBinding() {
        return new OutputBinding();
    }

    /**
     * Create an instance of {@link TaskGroupWorkflow }
     * 
     */
    public TaskGroupWorkflow createTaskGroupWorkflow() {
        return new TaskGroupWorkflow();
    }

    /**
     * Create an instance of {@link Task }
     * 
     */
    public Task createTask() {
        return new Task();
    }

    /**
     * Create an instance of {@link SequentialWorkflow }
     * 
     */
    public SequentialWorkflow createSequentialWorkflow() {
        return new SequentialWorkflow();
    }

    /**
     * Create an instance of {@link InputBinding }
     * 
     */
    public InputBinding createInputBinding() {
        return new InputBinding();
    }

    /**
     * Create an instance of {@link Dependencies }
     * 
     */
    public Dependencies createDependencies() {
        return new Dependencies();
    }

    /**
     * Create an instance of {@link ChainWorkflow }
     * 
     */
    public ChainWorkflow createChainWorkflow() {
        return new ChainWorkflow();
    }

    /**
     * Create an instance of {@link CostModelDefinition }
     * 
     */
    public CostModelDefinition createCostModelDefinition() {
        return new CostModelDefinition();
    }

    /**
     * Create an instance of {@link JAXBElement }{@code <}{@link Workflow }{@code >}}
     * 
     */
    @XmlElementDecl(namespace = "", name = "workflow")
    public JAXBElement<Workflow> createWorkflow(Workflow value) {
        return new JAXBElement<Workflow>(_Workflow_QNAME, Workflow.class, null, value);
    }

}