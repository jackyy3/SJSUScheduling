package org.workflow.scheduling.algorithms.iml;

import java.util.List;

import org.workflow.scheduling.algorithms.WorkflowSchedulingAlgorithmType;

public class FCFSWorkflowFileSchedulingAlgorithm implements WorkflowFileSchedulingAlgorithm {
	
	private WorkflowSchedulingAlgorithmType workflowSchedulingAlgorithmType;
	
	public FCFSWorkflowFileSchedulingAlgorithm(
			final WorkflowSchedulingAlgorithmType workflowSchedulingAlgorithmType) {
		this.workflowSchedulingAlgorithmType = workflowSchedulingAlgorithmType;
	}

	@Override
	public WorkflowSchedulingAlgorithmType getWorkflowSchedulingAlgorithmType() {
		return this.workflowSchedulingAlgorithmType;
	}

	@Override
	public List<String> scheduleWorkflows(List<String> workflows) {
		return workflows;
	}

}
