package org.workflow.scheduling.engine;

import java.util.List;
import java.util.concurrent.Future;

import org.workflow.process.ExecutionResult.ExecutionStatus;

public class SimResult {
	private ExecutionStatus status;
	private List<Long> tardinesses;
	private List<Long> durations;
	private long overallStartTime;
	private long overallCompletionTime;
	private long overallDuration;
	
	private Future future;

	public SimResult(final SimResultBuilder builder) {
		this.status = builder.getStatus();
		this.tardinesses = builder.getTardiness();
		this.durations = builder.getDuration();
		this.overallCompletionTime = builder.getOverallCompletionTime();
		this.overallStartTime = builder.getOverallStartTime();
		this.overallDuration = this.overallCompletionTime - this.overallStartTime;
		this.future = future;
	}

	public long getTotalDuration() {
		return this.overallDuration;
	}

	/**
	 * @return the status
	 */
	public ExecutionStatus getStatus() {
		return status;
	}

	/**
	 * @return the tardiness
	 */
	public List<Long> getTardiness() {
		return tardinesses;
	}

	/**
	 * @return the duration
	 */
	public List<Long> getDuration() {
		return durations;
	}

	/**
	 * @return the overallStartTime
	 */
	public long getOverallStartTime() {
		return overallStartTime;
	}

	/**
	 * @return the overallCompletionTime
	 */
	public long getOverallCompletionTime() {
		return overallCompletionTime;
	}
	
	public Future getFuture(){
		return this.future;
	}

	static class SimResultBuilder {
		private ExecutionStatus status;
		private List<Long> tardinesses;
		private List<Long> durations;
		private long overallStartTime;
		private long overallCompletionTime;
		
		private Future future;

		public SimResultBuilder() {
		}

		public SimResultBuilder overallStartTime(final long overallStartTime) {
			this.overallStartTime = overallStartTime;
			return this;
		}

		public SimResultBuilder overallCompletionTime(final long overallCompletionTime) {
			this.overallCompletionTime = overallCompletionTime;
			return this;
		}

		public SimResultBuilder executionStatus(final ExecutionStatus status) {
			this.status = status;
			return this;
		}

		public SimResultBuilder tardiness(final List<Long> tardinesses) {
			this.tardinesses = tardinesses;
			return this;
		}

		public SimResultBuilder duration(final List<Long> durations) {
			this.durations = durations;
			return this;
		}
		
		public SimResultBuilder future(Future future) {
			this.future = future;
			return this;
		}

		public SimResult build() {
			return new SimResult(this);
		}
		
		public Future getFuture(){
			return this.future;
		}

		/**
		 * @return the status
		 */
		public ExecutionStatus getStatus() {
			return status;
		}

		/**
		 * @return the tardiness
		 */
		public List<Long> getTardiness() {
			return tardinesses;
		}

		/**
		 * @return the duration
		 */
		public List<Long> getDuration() {
			return durations;
		}

		/**
		 * @return the overallStartTime
		 */
		public long getOverallStartTime() {
			return overallStartTime;
		}

		/**
		 * @return the overallCompletionTime
		 */
		public long getOverallCompletionTime() {
			return overallCompletionTime;
		}
	}
}
