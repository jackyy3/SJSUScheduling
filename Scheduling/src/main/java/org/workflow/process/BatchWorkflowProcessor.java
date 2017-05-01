package org.workflow.process;

import org.workflow.scheduling.BaseClusterSimWorkflow;

public class BatchWorkflowProcessor implements WorkflowProcessor<BaseClusterSimWorkflow> {

	private WorkflowExecutor workflowExecutor;

	public BatchWorkflowProcessor() {
		this.workflowExecutor = new WorkflowSimExecutor();
	}

	public BatchWorkflowProcessor(final WorkflowExecutor workflowExecutor) {
		this.workflowExecutor = workflowExecutor;
	}

	@Override
	public Result<BaseClusterSimWorkflow> processWorkflow(BaseClusterSimWorkflow t) {
		workflowExecutor.execute(t);
		return null;
	}

	@Override
	public WorkflowExecutor getWorkflowExecutor() {
		return this.workflowExecutor;
	}

}
