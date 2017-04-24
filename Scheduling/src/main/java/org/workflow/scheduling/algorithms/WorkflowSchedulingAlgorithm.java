package org.workflow.scheduling.algorithms;

import java.util.List;

import org.workflow.scheduling.ClusterSimWorkflow;
import org.workflow.scheduling.pool.SchedulingPriority;

public interface WorkflowSchedulingAlgorithm {

	WorkflowSchedulingAlgorithmType getWorkflowSchedulingAlgorithmType();
	
	List<ClusterSimWorkflow> scheduleWorkflows(final List<ClusterSimWorkflow> workflows);
	
	SchedulingPriority calculateSchedulingPriority(final ClusterSimWorkflow workflow);
}
