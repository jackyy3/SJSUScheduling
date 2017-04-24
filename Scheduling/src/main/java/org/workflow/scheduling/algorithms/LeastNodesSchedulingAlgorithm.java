package org.workflow.scheduling.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.workflow.scheduling.ClusterSimWorkflow;
import org.workflow.scheduling.comparator.LeastTasksComparator;
import org.workflow.scheduling.pool.SchedulingPriority;

public class LeastNodesSchedulingAlgorithm implements WorkflowSchedulingAlgorithm {

	private WorkflowSchedulingAlgorithmType workflowSchedulingAlgorithmType;
	
	public LeastNodesSchedulingAlgorithm(
			final WorkflowSchedulingAlgorithmType workflowSchedulingAlgorithmType) {
		this.workflowSchedulingAlgorithmType = workflowSchedulingAlgorithmType;
	}
	
	@Override
	public WorkflowSchedulingAlgorithmType getWorkflowSchedulingAlgorithmType() {
		return this.workflowSchedulingAlgorithmType;
	}

	@Override
	public List<ClusterSimWorkflow> scheduleWorkflows(List<ClusterSimWorkflow> workflows) {
		List<ClusterSimWorkflow> orderedWorkflows = new ArrayList<>(workflows);
		Collections.sort(orderedWorkflows, new LeastTasksComparator());
		return orderedWorkflows;
	}

	@Override
	public SchedulingPriority calculateSchedulingPriority(ClusterSimWorkflow workflow) {
		// TODO Auto-generated method stub
		return null;
	}

}
