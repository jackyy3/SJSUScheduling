package org.workflow.scheduling.factory;

import org.workflow.scheduling.algorithms.CostBasedWorkflowSchedulingAlgorithm;
import org.workflow.scheduling.algorithms.EDFWorkflowSchedulingAlgorithm;
import org.workflow.scheduling.algorithms.FCFSWorkflowSchedulingAlgorithm;
import org.workflow.scheduling.algorithms.WorkflowSchedulingAlgorithm;
import org.workflow.scheduling.algorithms.WorkflowSchedulingAlgorithmType;

public class WorkflowSchedulingAlgorithmFactory {

    public WorkflowSchedulingAlgorithm getWorkflowSchedulingAlgorithm(
    		final WorkflowSchedulingAlgorithmType workflowSchedulingAlgorithmType) {
    	if (workflowSchedulingAlgorithmType == WorkflowSchedulingAlgorithmType.FCFS) {
    		return new FCFSWorkflowSchedulingAlgorithm(WorkflowSchedulingAlgorithmType.FCFS);
    	} else if (workflowSchedulingAlgorithmType == WorkflowSchedulingAlgorithmType.EDF){
    		return new EDFWorkflowSchedulingAlgorithm(WorkflowSchedulingAlgorithmType.EDF);
    	}  else {
    		return new CostBasedWorkflowSchedulingAlgorithm(WorkflowSchedulingAlgorithmType.COSTBASED);
    	}
    }
}
