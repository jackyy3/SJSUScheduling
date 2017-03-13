package org.workflow.scheduling.task;

import org.workflow.scheduling.pool.SchedulingPriority;

public class WorkflowTask extends org.workflow.Task {

	private long workflowId;

	public WorkflowTask(final int taskId, final long taskLength, final long workflowId) {
		super(taskId, taskLength);
		this.workflowId = workflowId;
	}

	public long getWorkflowId() {
		return workflowId;
	}

	public void setWorkflowId(final long workflowId) {
		this.workflowId = workflowId;
	}

}
