package org.workflow.scheduling.algorithms.iml;

import java.util.List;

import org.workflow.scheduling.algorithms.WorkflowSchedulingAlgorithmType;

public interface WorkflowFileSchedulingAlgorithm {
	
	WorkflowSchedulingAlgorithmType getWorkflowSchedulingAlgorithmType();
	
	List<String> scheduleWorkflows(final List<String> workflows);
}
