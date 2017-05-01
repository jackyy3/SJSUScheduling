package org.workflow.process;

import org.workflow.process.ExecutionResult.ExecutionStatus;

public class Result<T> {
	private ExecutionStatus status;
	private long actualCompletionTime;
	private long actualStartTime;
	private long actualArrivalTime;
	private T t;

	public Result(ResultBuilder<T> resultBuilder) {
		this.status = resultBuilder.getStatus();
		this.actualArrivalTime = resultBuilder.getActualArrivalTime();
		this.actualStartTime = resultBuilder.getActualStartTime();
		this.actualCompletionTime = resultBuilder.getActualCompletionTime();
		this.t = resultBuilder.getT();
	}

	/**
	 * @return the status
	 */
	public ExecutionStatus getStatus() {
		return status;
	}

	/**
	 * @return the actualCompletionTime
	 */
	public long getActualCompletionTime() {
		return actualCompletionTime;
	}

	/**
	 * @return the actualStartTime
	 */
	public long getActualStartTime() {
		return actualStartTime;
	}

	/**
	 * @return the actualArrivalTime
	 */
	public long getActualArrivalTime() {
		return actualArrivalTime;
	}

	/**
	 * @return the t
	 */
	public T getT() {
		return t;
	}
	
	public long getTardiness(){
		return (this.actualStartTime - this.actualArrivalTime);
	}
	
	public long getLifeTimeDuration(){
		return (this.actualCompletionTime - this.actualArrivalTime);
	}

	public static class ResultBuilder<T> {
		private ExecutionStatus status;
		private long actualCompletionTime;
		private long actualStartTime;
		private long actualArrivalTime;
		private final T t;

		public ResultBuilder(final T t) {
			this.t = t;
		}

		public ResultBuilder<T> ExecutionStatus(final ExecutionStatus status) {
			this.status = status;
			return this;
		}

		public ResultBuilder<T> ActualCompletionTime(final long actualCompletionTime) {
			this.actualCompletionTime = actualCompletionTime;
			return this;
		}

		public ResultBuilder<T> actualStartTime(final long actualStartTime) {
			this.actualStartTime = actualStartTime;
			return this;
		}

		public ResultBuilder<T> actualArrivalTime(final long actualArrivalTime) {
			this.actualArrivalTime = actualArrivalTime;
			return this;
		}

		public Result<T> build() {
			return new Result<T>(this);
		}

		/**
		 * @return the status
		 */
		public ExecutionStatus getStatus() {
			return status;
		}

		/**
		 * @return the actualCompletionTime
		 */
		public long getActualCompletionTime() {
			return actualCompletionTime;
		}

		/**
		 * @return the actualStartTime
		 */
		public long getActualStartTime() {
			return actualStartTime;
		}

		/**
		 * @return the actualArrivalTime
		 */
		public long getActualArrivalTime() {
			return actualArrivalTime;
		}

		/**
		 * @return the t
		 */
		public T getT() {
			return t;
		}
	}
}
