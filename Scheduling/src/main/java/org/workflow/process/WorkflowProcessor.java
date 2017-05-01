package org.workflow.process;

public interface WorkflowProcessor<T> {
	Result<T> processWorkflow(T t);
	
	WorkflowExecutor getWorkflowExecutor();
}
