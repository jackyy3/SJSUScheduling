package org.workflow.process;

public class ExecutionResult<T> {
	private final T t;
	private final ExecutionStatus status;

	public ExecutionResult(final T t, final ExecutionStatus status) {
		this.t = t;
		this.status = status;
	}
	
	/**
	 * @return the t
	 */
	public T getT() {
		return t;
	}

	/**
	 * @return the status
	 */
	public ExecutionStatus getStatus() {
		return status;
	}

	public static enum ExecutionStatus{
		SUCCESSFUL, FAILED;
	}
}
