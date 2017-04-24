package org.workflow.scheduling;

import java.util.List;

import org.sjsu.wfs.workflow.WorkflowType;
import org.workflow.Task;
import org.workflow.scheduling.pool.SchedulingPriority;

public class BaseClusterSimWorkflow implements ClusterSimWorkflow {
	private long arrivalTime;
	private long simpleMissingDeadlineCost;
	private long deadline;
	private String daxPath;
	private final String workflowId;
	private long actualCompletionTime;
	private long actualStartTime;
	private List<Task> tasks;
	private SchedulingPriority schedulingPriority;

	private Long totalSize;
	private long estimatedDuration;
	private WorkflowType workflowType;
	private String workflowName;

	public BaseClusterSimWorkflow(final String workflowId) {
		this.workflowId = workflowId;
	}

	public String getDaxPath() {
		return this.daxPath;
	}

	public void setDataPath(final String dataPath) {
		this.daxPath = dataPath;
	}

	public void setArrivalTime(final long arrivalTime) {
		this.arrivalTime = arrivalTime;
	}

	public void setSimpleMissingDeadlineCost(final long simpleMissingDeadlineCost) {
		this.simpleMissingDeadlineCost = simpleMissingDeadlineCost;
	}

	public void setDeadline(final long deadline) {
		this.deadline = deadline;
	}

	public long getArrivalTime() {
		return this.arrivalTime;
	}

	public long getSimpleMissingDeadlineCost() {
		return this.simpleMissingDeadlineCost;
	}

	public long getDeadline() {
		return this.deadline;
	}

	public long getActualCompletionTime() {
		return this.actualCompletionTime;
	}

	public void setActualCompletionTime(final long actualCompletionTime) {
		this.actualCompletionTime = actualCompletionTime;
	}

	public long getActualStartTime() {
		return actualStartTime;
	}

	public void setActualStartTime(final long actualStartTime) {
		this.actualStartTime = actualStartTime;
	}

	public void setTasks(final List<Task> tasks) {
		this.tasks = tasks;
	}

	public void addTask(final Task task) {
		this.tasks.add(task);
	}

	public List<Task> getTasks() {
		return this.tasks;
	}

	@Override
	public String getWorkflowId() {
		return this.workflowId;
	}

	/**
	 * @return the schedulingPriority
	 */
	public SchedulingPriority getSchedulingPriority() {
		return schedulingPriority;
	}

	/**
	 * @param schedulingPriority
	 *            the schedulingPriority to set
	 */
	public void setSchedulingPriority(final SchedulingPriority schedulingPriority) {
		this.schedulingPriority = schedulingPriority;
	}

	/**
	 * @return the totalSize
	 */
	public Long getTotalSize() {
		return totalSize;
	}

	/**
	 * @param totalSize
	 *            the totalSize to set
	 */
	public void setTotalSize(Long totalSize) {
		this.totalSize = totalSize;
	}

	/**
	 * @return the estimatedDuration
	 */
	public long getEstimatedDuration() {
		return estimatedDuration;
	}

	/**
	 * @param estimatedDuration
	 *            the estimatedDuration to set
	 */
	public void setEstimatedDuration(long estimatedDuration) {
		this.estimatedDuration = estimatedDuration;
	}

	/**
	 * @return the workflowType
	 */
	public WorkflowType getWorkflowType() {
		return workflowType;
	}

	/**
	 * @param workflowType
	 *            the workflowType to set
	 */
	public void setWorkflowType(WorkflowType workflowType) {
		this.workflowType = workflowType;
	}

	/**
	 * @return the workflowName
	 */
	public String getWorkflowName() {
		return workflowName;
	}

	/**
	 * @param workflowName
	 *            the workflowName to set
	 */
	public void setWorkflowName(String workflowName) {
		this.workflowName = workflowName;
	}
}
