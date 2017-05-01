package org.workflow.process;

import org.workflow.process.Result.ResultBuilder;
import org.workflow.scheduling.BaseClusterSimWorkflow;

public class RealTimeWorkflowProcessor implements WorkflowProcessor<BaseClusterSimWorkflow> {

	private WorkflowExecutor workflowExecutor;

	public RealTimeWorkflowProcessor() {
		this.workflowExecutor = new WorkflowSimExecutor();
	}

	public RealTimeWorkflowProcessor(WorkflowExecutor workflowExecutor) {
		this.workflowExecutor = workflowExecutor;
	}

	@Override
	public Result<BaseClusterSimWorkflow> processWorkflow(BaseClusterSimWorkflow t) {
		ExecutionResult<BaseClusterSimWorkflow> executionResult = workflowExecutor.execute(t);
		ResultBuilder<BaseClusterSimWorkflow> rb = new ResultBuilder<BaseClusterSimWorkflow>(t);
		rb.actualArrivalTime(t.getArrivalTime());
		rb.ActualCompletionTime(t.getActualCompletionTime());
		rb.actualStartTime(t.getActualStartTime());
		rb.ExecutionStatus(executionResult.getStatus());
		return new Result<BaseClusterSimWorkflow>(rb);
	}

	@Override
	public WorkflowExecutor getWorkflowExecutor() {
		return this.workflowExecutor;
	}

}
