package org.workflow.scheduling.pool;

import java.util.Vector;

import org.workflow.scheduling.BaseWorkflow;
import org.workflow.scheduling.Workflow;

public class PoolTasksContainer {

	private final SchedulingPriority schedulingPriority;
	private final Vector<BaseWorkflow> workflows = new Vector<>();

	public PoolTasksContainer(final SchedulingPriority schedulingPriority) {
		this.schedulingPriority = schedulingPriority;
	}

	/**
	 * @return the schedulingPriority
	 */
	public SchedulingPriority getSchedulingPriority() {
		return schedulingPriority;
	}

	public void addToContainer(final BaseWorkflow workflow) {
		if (!workflow.getSchedulingPriority().equals(this.schedulingPriority)) {
			// throw new exception
		}
		this.workflows.addElement(workflow);
	}

	public void removeFromContainer(final Workflow workflow) {
		this.workflows.remove(workflow);
	}

	public boolean isContainerEmpty() {
        return this.workflows.isEmpty();
	}
	
	public BaseWorkflow retrieveNextWorkflow(final SchedulingPriority schedulingPriority){
		if(this.schedulingPriority != schedulingPriority || this.isContainerEmpty()){
			return null;
		}
		BaseWorkflow bwf = this.workflows.get(0);
		this.removeFromContainer(bwf);
		return bwf;
	}
}
