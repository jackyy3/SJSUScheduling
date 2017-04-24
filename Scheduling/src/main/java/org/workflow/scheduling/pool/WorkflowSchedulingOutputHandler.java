package org.workflow.scheduling.pool;

import org.workflow.scheduling.BaseClusterSimWorkflow;

/**
 * Handles output from workflow scheduling.
 */
public class WorkflowSchedulingOutputHandler extends AbstractSchedulingOutputHandler {

	/**
	 * Execute next READY scheduled workflow.
	 * 
	 * @param workflow
	 */
	public void execute(final BaseClusterSimWorkflow workflow) {
		System.out.println("success " + workflow.getSchedulingPriority().getPriorityIndex());
	}
}
