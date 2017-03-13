package org.workflow.scheduling.algorithms;

import java.util.List;

import org.workflow.scheduling.Workflow;
import org.workflow.scheduling.pool.SchedulingPriority;

public interface WorkflowSchedulingAlgorithm {

	WorkflowSchedulingAlgorithmType getWorkflowSchedulingAlgorithmType();
	
	List<Workflow> scheduleWorkflows(final List<Workflow> workflows);
	
	SchedulingPriority calculateSchedulingPriority(final Workflow workflow);
}
