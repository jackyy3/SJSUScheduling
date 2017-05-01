package org.workflow.process;

import org.workflow.scheduling.BaseClusterSimWorkflow;

public interface WorkflowExecutor {
	ExecutionResult execute(BaseClusterSimWorkflow simWorkflow);
}
