package org.sjsu.wfs.workflow.util;

import org.sjsu.wfs.workflow.ChainWorkflow;
import org.sjsu.wfs.workflow.CostModelDefinition;
import org.sjsu.wfs.workflow.SequentialWorkflow;
import org.sjsu.wfs.workflow.TaskContainer;
import org.sjsu.wfs.workflow.TaskGroupWorkflow;
import org.sjsu.wfs.workflow.Workflow;
import org.sjsu.wfs.workflow.WorkflowType;

public class WorkflowBuilder {

	private Workflow workflow;
	private String workflowId;

	public WorkflowBuilder(final WorkflowType workflowType) {
		if (workflowType == WorkflowType.FULLY_PARALLEL) {
			this.workflow = new TaskGroupWorkflow();
		} else if (workflowType == WorkflowType.SEQUENTIAL) {
			this.workflow = new SequentialWorkflow();
		} else {
			this.workflow = new ChainWorkflow();
		}
		this.workflow.setWorkflowType(workflowType);
		this.workflowId = this.workflow.getWorkflowId();
	}

	public WorkflowBuilder inputFilePath(final String inputFilePath) {
		this.workflow.setInputFilePath(inputFilePath);
		return this;
	}

	public WorkflowBuilder numberOfTasks(final long numberOfTasks) {
		this.workflow.setNumberOfTasks(numberOfTasks);
		return this;
	}

	public WorkflowBuilder costModel(final CostModelDefinition costModel) {
		this.workflow.setCostModel(costModel);
		return this;
	}

	public WorkflowBuilder totalSize(final long totalSize) {
		this.workflow.setTotalSize(totalSize);
		return this;
	}

	public WorkflowBuilder estimatedDuration(final long estimatedDuration) {
		this.workflow.setEstimatedDuration(estimatedDuration);
		return this;
	}

	public WorkflowBuilder tasksContainer(final TaskContainer tasks) {
		this.workflow.setTasks(tasks);
		return this;
	}

	public WorkflowBuilder workflowName(final String name) {
		this.workflow.setName(name);
		return this;
	}
	
	public WorkflowBuilder deadline(final long deadline){
		this.workflow.setDeadline(deadline);
		return this;
	}
	
	public String getWorkflowId(){
		return this.workflowId;
	}

	public Workflow build() {
		return this.workflow;
	}
}
