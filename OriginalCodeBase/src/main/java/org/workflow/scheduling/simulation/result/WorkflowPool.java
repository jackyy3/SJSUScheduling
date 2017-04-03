package org.workflow.scheduling.simulation.result;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.workflow.Task;
import org.workflow.scheduling.BaseWorkflow;
import org.workflow.scheduling.Workflow;

public enum WorkflowPool {
	
	INSTANCE;
	
	private final Map<Long, Workflow> workflows = new HashMap<>();

	
	public void addToWorkflows(final Task task, final Workflow workflow) {
		this.workflows.put((long) task.getCloudletId(), workflow);
	}
	
	public Map<Long, Workflow> getWorkflows() {
		return this.workflows;
	}
	
	public Workflow getSingleWorkflow(final Long taskId) {
		return workflows.get(taskId);
	}
	
	public boolean contains(final long taskId) {
		return workflows.containsKey(taskId);
	}
	
	public boolean contains(final Workflow workflow) {
		return workflows.containsValue(workflow);
	}
	
	public List<BaseWorkflow> aggregateWorkflows(final List<? extends Task> tasks) {
		
		for(Task task : tasks){
			
		}
		return null;
	}
}
