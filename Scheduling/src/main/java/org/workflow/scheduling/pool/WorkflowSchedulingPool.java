package org.workflow.scheduling.pool;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.workflow.scheduling.BaseClusterSimWorkflow;

/**
 * Workflow Ready Pool.
 */
public class WorkflowSchedulingPool extends AbstractSchedulingPool {

	private final Map<SchedulingPriority, PoolTasksContainer> workflowPool = new ConcurrentHashMap<>();

	/**
	 * Add Workflow to Ready Pool.
	 *
	 * @param workflow
	 */
	public void addToPool(final BaseClusterSimWorkflow workflow) {
		SchedulingPriority schedulingPriority = workflow.getSchedulingPriority();
		PoolTasksContainer container = null;
		if (workflowPool.containsKey(schedulingPriority)) {
			container = workflowPool.get(schedulingPriority);
		} else {
			container = new PoolTasksContainer(schedulingPriority);
		}
		container.addToContainer(workflow);
		workflowPool.put(schedulingPriority, container);
	}

	/**
	 * Remove workflow from READY pool.
	 *
	 * @param workflow
	 */
	public void removeFromPool(final BaseClusterSimWorkflow workflow) {
		SchedulingPriority schedulingPriority = workflow.getSchedulingPriority();
		if (workflowPool.containsKey(schedulingPriority)) {
			PoolTasksContainer container = workflowPool.get(schedulingPriority);
			container.removeFromContainer(workflow);
			if(container.isContainerEmpty()){
				workflowPool.remove(schedulingPriority);
			}
		}
	}

	/**
	 * Retrieves next READY workflow given priority.
	 * 
	 * @param sp
	 * @return next ready workflow
	 */
	public BaseClusterSimWorkflow retrieveNextWorkflow(final SchedulingPriority sp) {
		if (!this.poolContainsWF(sp)) {
			return null;
		}
		BaseClusterSimWorkflow wf = this.workflowPool.get(sp).retrieveNextWorkflow(sp);
		this.removeFromPool(wf);
		return wf;
	}

	/**
	 * Identify whether the pool contains workflows with given priority.
	 * 
	 * @param sp
	 * @return True or False.
	 */
	public boolean poolContainsWF(final SchedulingPriority sp) {
		if (!this.workflowPool.containsKey(sp)) {
			return false;
		}
		if (this.workflowPool.get(sp).isContainerEmpty()) {
			return false;
		}
		return true;
	}
	
	public synchronized boolean isPoolEmpty(){
		return this.workflowPool.isEmpty();
	}
	
	public synchronized long getPoolSize(){
		return this.workflowPool.size();
	}
}
