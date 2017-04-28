package org.workflow.scheduling.pool;

import org.sjsu.wfs.workflow.Workflow;
import org.sjsu.wfs.workflow.generation.RandomWorkflowFactory;
import org.sjsu.wfs.workflow.generation.WorkflowFactory;
import org.workflow.scheduling.BaseClusterSimWorkflow;
import org.workflow.scheduling.adapter.GenericWorkflowAdapter;

/**
 * Takes inputs from source.
 * 
 * TODO:implementation.
 */
public class InputStreamingListener {

	private WorkflowFactory wfFactory = new RandomWorkflowFactory();

	/**
	 * Return next workflow for scheduling.
	 * 
	 * @return workflow
	 */
	public BaseClusterSimWorkflow nextWorkflow() {
		Workflow wf = wfFactory.createSingleWorkflow();
		BaseClusterSimWorkflow bwf = (BaseClusterSimWorkflow) (new GenericWorkflowAdapter(wf)).adapt();
		return bwf;
	}

	/**
	 * @param filePath
	 *
	 * @return {@link BaseClusterSimWorkflow}
	 */
	public BaseClusterSimWorkflow nextWorkflow(final String filePath) {
		Workflow wf = wfFactory.createSingleWorkflow(filePath);
		BaseClusterSimWorkflow bwf = (BaseClusterSimWorkflow) (new GenericWorkflowAdapter(wf)).adapt();
		return bwf;
	}
}
