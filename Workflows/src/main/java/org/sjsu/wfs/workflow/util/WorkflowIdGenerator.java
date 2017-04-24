package org.sjsu.wfs.workflow.util;

public enum WorkflowIdGenerator {

	INSTANCE;

	private long workflowId = 0L;

	public synchronized String generateId() {
		return String.valueOf(workflowId++);
	}
}
