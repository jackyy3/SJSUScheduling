package org.workflow.scheduling.algorithms;

import java.util.List;

import org.workflow.scheduling.ClusterSimWorkflow;
import org.workflow.scheduling.pool.SchedulingPriority;

public class CostBasedWorkflowSchedulingAlgorithm implements WorkflowSchedulingAlgorithm {

	private WorkflowSchedulingAlgorithmType workflowSchedulingAlgorithmType;

	public CostBasedWorkflowSchedulingAlgorithm(final WorkflowSchedulingAlgorithmType workflowSchedulingAlgorithmType) {
		this.workflowSchedulingAlgorithmType = workflowSchedulingAlgorithmType;
	}

	@Override
	public WorkflowSchedulingAlgorithmType getWorkflowSchedulingAlgorithmType() {

		return this.workflowSchedulingAlgorithmType;
	}

	@Override
	public List<ClusterSimWorkflow> scheduleWorkflows(List<ClusterSimWorkflow> workflows) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public SchedulingPriority calculateSchedulingPriority(ClusterSimWorkflow workflow) {
		// TODO Auto-generated method stub
		return null;
	}

}
