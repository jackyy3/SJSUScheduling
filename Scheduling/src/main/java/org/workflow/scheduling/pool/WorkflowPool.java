package org.workflow.scheduling.pool;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.workflow.Task;
import org.workflow.scheduling.BaseClusterSimWorkflow;
import org.workflow.scheduling.ClusterSimWorkflow;

public enum WorkflowPool {
	
	INSTANCE;
	
	private final Map<Long, ClusterSimWorkflow> workflows = new HashMap<>();

	
	public void addToWorkflows(final Task task, final ClusterSimWorkflow workflow) {
		this.workflows.put((long) task.getCloudletId(), workflow);
	}
	
	public Map<Long, ClusterSimWorkflow> getWorkflows() {
		return this.workflows;
	}
	
	public ClusterSimWorkflow getSingleWorkflow(final Long taskId) {
		return workflows.get(taskId);
	}
	
	public boolean contains(final long taskId) {
		return workflows.containsKey(taskId);
	}
	
	public boolean contains(final ClusterSimWorkflow workflow) {
		return workflows.containsValue(workflow);
	}
	
	public List<BaseClusterSimWorkflow> aggregateWorkflows(final List<? extends Task> tasks) {
		
		for(Task task : tasks){
			
		}
		return null;
	}
}
