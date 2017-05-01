package org.workflow.scheduling.pool;

import org.sjsu.wfs.workflow.generation.RandomWorkflowFactory;
import org.workflow.scheduling.BaseClusterSimWorkflow;
import org.workflow.scheduling.algorithms.WorkflowSchedulingAlgorithm;
import org.workflow.scheduling.algorithms.WorkflowSchedulingAlgorithmType;
import org.workflow.scheduling.factory.WorkflowSchedulingAlgorithmFactory;

/**
 * Main Scheduling component which integrates with specific scheduling
 * algorithm.
 */
public class WorkflowPriorityCalculator extends AbstractSchedulingInputHandler {

	private final WorkflowSchedulingAlgorithmType algorithmType;
	private final WorkflowSchedulingAlgorithm schedulingAlgorithm;
	private InputStreamingListener listener;

	/**
	 * Default constructor.
	 */
	public WorkflowPriorityCalculator() {
		this(WorkflowSchedulingAlgorithmType.FCFS, new InputStreamingListener(new RandomWorkflowFactory()));
	}

	/**
	 * Constructor with given scheduling algorithm.
	 * 
	 * @param algorithmType
	 */
	public WorkflowPriorityCalculator(final WorkflowSchedulingAlgorithmType algorithmType,
			final InputStreamingListener listener) {
		this.algorithmType = algorithmType;
		this.schedulingAlgorithm = this.getWorkflowSchedulingAlgorithm();
		this.listener = listener;
	}

	/**
	 * Gets current workflow scheduling algorithm.
	 * 
	 * @return scheduling algorithm
	 */
	public WorkflowSchedulingAlgorithm getWorkflowSchedulingAlgorithm() {
		return (new WorkflowSchedulingAlgorithmFactory()).getWorkflowSchedulingAlgorithm(this.algorithmType);
	}

	/**
	 * Outputs workflow with priority.
	 *
	 * @return next READY workflow with priority.
	 */
	public BaseClusterSimWorkflow getNextWorkflow() {
		BaseClusterSimWorkflow wf = this.listener.nextWorkflow();
		SchedulingPriority priority = this.schedulingAlgorithm.calculateSchedulingPriority(wf);
		wf.setSchedulingPriority(priority);
		return wf;
	}
}
