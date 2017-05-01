package org.workflow.scheduling.pool;

import org.workflow.process.RealTimeWorkflowProcessor;
import org.workflow.process.Result;
import org.workflow.process.WorkflowProcessor;
import org.workflow.scheduling.BaseClusterSimWorkflow;

/**
 * Handles output from workflow scheduling.
 */
public class WorkflowSchedulingOutputHandler extends AbstractSchedulingOutputHandler<BaseClusterSimWorkflow> {

	public WorkflowSchedulingOutputHandler(){
		super(new RealTimeWorkflowProcessor());
	}
	
	public WorkflowSchedulingOutputHandler(WorkflowProcessor<BaseClusterSimWorkflow> workflowProcessor){
		super(workflowProcessor);
	}
	
	/**
	 * Execute next READY scheduled workflow.
	 * 
	 * @param workflow
	 */
	public Result<BaseClusterSimWorkflow> execute(final BaseClusterSimWorkflow workflow) {
		System.out.println("success " + workflow.getSchedulingPriority().getPriorityIndex());
		return processor.processWorkflow(workflow);
	}
}
