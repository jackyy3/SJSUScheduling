package org.workflow.scheduling.factory;

import org.workflow.scheduling.algorithms.WorkflowSchedulingAlgorithmType;
import org.workflow.scheduling.algorithms.iml.FCFSWorkflowFileSchedulingAlgorithm;
import org.workflow.scheduling.algorithms.iml.LeastComplexityFileSchedulingAlgorithm;
import org.workflow.scheduling.algorithms.iml.LeastNodesFileSchedulingAlgorithm;
import org.workflow.scheduling.algorithms.iml.WorkflowFileSchedulingAlgorithm;

public class FileWorkflowSchedulingAlgorithmFactory {
    public WorkflowFileSchedulingAlgorithm getWorkflowSchedulingAlgorithm(
    		final WorkflowSchedulingAlgorithmType workflowSchedulingAlgorithmType) {
    	if (workflowSchedulingAlgorithmType == WorkflowSchedulingAlgorithmType.FCFS) {
    		return new FCFSWorkflowFileSchedulingAlgorithm(WorkflowSchedulingAlgorithmType.FCFS);
    	} else if (workflowSchedulingAlgorithmType == WorkflowSchedulingAlgorithmType.LEAST_COMPLEXITY){
    		return new LeastComplexityFileSchedulingAlgorithm(WorkflowSchedulingAlgorithmType.LEAST_COMPLEXITY);
    	}  else {
    		return new LeastNodesFileSchedulingAlgorithm(WorkflowSchedulingAlgorithmType.LEAST_NODES);
    	}
    }
}
