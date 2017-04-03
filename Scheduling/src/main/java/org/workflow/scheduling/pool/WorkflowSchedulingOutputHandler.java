package org.workflow.scheduling.pool;

import org.workflow.scheduling.BaseWorkflow;

/**
 * Handles output from workflow scheduling.
 */
public class WorkflowSchedulingOutputHandler extends AbstractSchedulingOutputHandler {

	/**
	 * Execute next READY scheduled workflow.
	 * 
	 * @param workflow
	 */
	public void execute(final BaseWorkflow workflow) {
		System.out.println("success " + workflow.getSchedulingPriority().getPriorityIndex());
	}
}
