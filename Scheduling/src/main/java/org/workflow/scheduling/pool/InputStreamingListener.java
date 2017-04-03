package org.workflow.scheduling.pool;

import org.workflow.scheduling.BaseWorkflow;

/**
 * Takes inputs from source.
 * 
 * TODO:implementation.
 */
public class InputStreamingListener {
	/**
	 * Return next workflow for scheduling.
	 * 
	 * @return workflow
	 */
	public BaseWorkflow nextWorkflow() {
		BaseWorkflow wf = new BaseWorkflow(null);
		return wf;
	}
}
