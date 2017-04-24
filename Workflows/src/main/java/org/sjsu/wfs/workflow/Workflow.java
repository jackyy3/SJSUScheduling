//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.4-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2017.04.23 at 09:00:35 PM PDT 
//


package org.sjsu.wfs.workflow;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.bind.annotation.XmlType;

import org.sjsu.wfs.workflow.util.WorkflowIdGenerator;


/**
 * 
 * 				Abstract, there are different types of workflows:
 * 				Sequential (not parallel at all), Chain (partial parallel),
 * 				TaskGroup (parallel)
 * 			
 * 
 * <p>Java class for Workflow complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Workflow">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="workflowId" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *         &lt;element name="inputFilePath" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *         &lt;element name="numberOfTasks" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="costModel" type="{}costModelDefinition" minOccurs="0"/>
 *         &lt;element name="totalSize" type="{http://www.w3.org/2001/XMLSchema}long" minOccurs="0"/>
 *         &lt;element name="deadline" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="estimatedDuration" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="tasks" type="{}TaskContainer" minOccurs="0"/>
 *         &lt;element name="workflowType" type="{}WorkflowType" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Workflow", propOrder = {
    "workflowId",
    "inputFilePath",
    "numberOfTasks",
    "costModel",
    "totalSize",
    "deadline",
    "estimatedDuration",
    "tasks",
    "workflowType"
})
@XmlSeeAlso({
    TaskGroupWorkflow.class,
    SequentialWorkflow.class,
    ChainWorkflow.class
})
public abstract class Workflow {

    @XmlElement(required = true)
    protected String workflowId;
    protected String inputFilePath;
    protected long numberOfTasks;
    protected CostModelDefinition costModel;
    protected Long totalSize;
    protected long deadline;
    protected long estimatedDuration;
    protected TaskContainer tasks;
    protected WorkflowType workflowType;
    @XmlAttribute(name = "name")
    protected String name;

    public Workflow(){
    	this.workflowId = WorkflowIdGenerator.INSTANCE.generateId();
    }
    
    /**
     * Gets the value of the workflowId property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getWorkflowId() {
        return workflowId;
    }

    /**
     * Sets the value of the workflowId property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setWorkflowId(String value) {
        this.workflowId = value;
    }

    /**
     * Gets the value of the inputFilePath property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getInputFilePath() {
        return inputFilePath;
    }

    /**
     * Sets the value of the inputFilePath property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setInputFilePath(String value) {
        this.inputFilePath = value;
    }

    /**
     * Gets the value of the numberOfTasks property.
     * 
     */
    public long getNumberOfTasks() {
        return numberOfTasks;
    }

    /**
     * Sets the value of the numberOfTasks property.
     * 
     */
    public void setNumberOfTasks(long value) {
        this.numberOfTasks = value;
    }

    /**
     * Gets the value of the costModel property.
     * 
     * @return
     *     possible object is
     *     {@link CostModelDefinition }
     *     
     */
    public CostModelDefinition getCostModel() {
        return costModel;
    }

    /**
     * Sets the value of the costModel property.
     * 
     * @param value
     *     allowed object is
     *     {@link CostModelDefinition }
     *     
     */
    public void setCostModel(CostModelDefinition value) {
        this.costModel = value;
    }

    /**
     * Gets the value of the totalSize property.
     * 
     * @return
     *     possible object is
     *     {@link Long }
     *     
     */
    public Long getTotalSize() {
        return totalSize;
    }

    /**
     * Sets the value of the totalSize property.
     * 
     * @param value
     *     allowed object is
     *     {@link Long }
     *     
     */
    public void setTotalSize(Long value) {
        this.totalSize = value;
    }

    /**
     * Gets the value of the deadline property.
     * 
     */
    public long getDeadline() {
        return deadline;
    }

    /**
     * Sets the value of the deadline property.
     * 
     */
    public void setDeadline(long value) {
        this.deadline = value;
    }

    /**
     * Gets the value of the estimatedDuration property.
     * 
     */
    public long getEstimatedDuration() {
        return estimatedDuration;
    }

    /**
     * Sets the value of the estimatedDuration property.
     * 
     */
    public void setEstimatedDuration(long value) {
        this.estimatedDuration = value;
    }

    /**
     * Gets the value of the tasks property.
     * 
     * @return
     *     possible object is
     *     {@link TaskContainer }
     *     
     */
    public TaskContainer getTasks() {
        return tasks;
    }

    /**
     * Sets the value of the tasks property.
     * 
     * @param value
     *     allowed object is
     *     {@link TaskContainer }
     *     
     */
    public void setTasks(TaskContainer value) {
        this.tasks = value;
    }

    /**
     * Gets the value of the workflowType property.
     * 
     * @return
     *     possible object is
     *     {@link WorkflowType }
     *     
     */
    public WorkflowType getWorkflowType() {
        return workflowType;
    }

    /**
     * Sets the value of the workflowType property.
     * 
     * @param value
     *     allowed object is
     *     {@link WorkflowType }
     *     
     */
    public void setWorkflowType(WorkflowType value) {
        this.workflowType = value;
    }

    /**
     * Gets the value of the name property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setName(String value) {
        this.name = value;
    }

}