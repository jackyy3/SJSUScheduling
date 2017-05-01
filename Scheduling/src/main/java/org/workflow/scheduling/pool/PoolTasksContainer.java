package org.workflow.scheduling.pool;

import java.util.Vector;

import org.workflow.scheduling.BaseClusterSimWorkflow;
import org.workflow.scheduling.ClusterSimWorkflow;

public class PoolTasksContainer {

	private final SchedulingPriority schedulingPriority;
	private final Vector<BaseClusterSimWorkflow> workflows = new Vector<>();

	public PoolTasksContainer(final SchedulingPriority schedulingPriority) {
		this.schedulingPriority = schedulingPriority;
	}

	/**
	 * @return the schedulingPriority
	 */
	public SchedulingPriority getSchedulingPriority() {
		return schedulingPriority;
	}

	public void addToContainer(final BaseClusterSimWorkflow workflow) {
		if (!workflow.getSchedulingPriority().equals(this.schedulingPriority)) {
			// throw new exception
		}
		this.workflows.addElement(workflow);
	}

	public void removeFromContainer(final ClusterSimWorkflow workflow) {
		this.workflows.remove(workflow);
	}

	public synchronized boolean isContainerEmpty() {
        return this.workflows.isEmpty();
	}
	
	public BaseClusterSimWorkflow retrieveNextWorkflow(final SchedulingPriority schedulingPriority){
		if((!this.schedulingPriority.equals(schedulingPriority)) || this.isContainerEmpty()){
			return null;
		}
		BaseClusterSimWorkflow bwf = this.workflows.get(0);
		this.removeFromContainer(bwf);
		return bwf;
	}
}
