package org.workflow.scheduling.algorithms;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.workflow.scheduling.ClusterSimWorkflow;
import org.workflow.scheduling.comparator.DeadlineComparator;
import org.workflow.scheduling.pool.SchedulingPriority;

public class EDFWorkflowSchedulingAlgorithm implements WorkflowSchedulingAlgorithm {

	private WorkflowSchedulingAlgorithmType workflowSchedulingAlgorithmType;
	
	public EDFWorkflowSchedulingAlgorithm(final WorkflowSchedulingAlgorithmType workflowSchedulingAlgorithmType) {
		this.workflowSchedulingAlgorithmType = workflowSchedulingAlgorithmType;
	}
	
	@Override
	public WorkflowSchedulingAlgorithmType getWorkflowSchedulingAlgorithmType() {
		return this.workflowSchedulingAlgorithmType;
	}

	@Override
	public List<ClusterSimWorkflow> scheduleWorkflows(List<ClusterSimWorkflow> workflows) {
		List<ClusterSimWorkflow> orderedWorkflows = new ArrayList<>(workflows);
		Collections.sort(orderedWorkflows, new DeadlineComparator());
		return orderedWorkflows;
	}

	@Override
	public SchedulingPriority calculateSchedulingPriority(ClusterSimWorkflow workflow) {
		long priorityValue = workflow.getDeadline() - System.currentTimeMillis();
		return new SchedulingPriority(priorityValue);
	}

}
