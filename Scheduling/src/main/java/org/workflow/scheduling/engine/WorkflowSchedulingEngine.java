package org.workflow.scheduling.engine;

import java.util.Random;

import org.workflow.scheduling.BaseClusterSimWorkflow;
import org.workflow.scheduling.pool.SchedulingPriority;
import org.workflow.scheduling.pool.WorkflowPriorityCalculator;
import org.workflow.scheduling.pool.WorkflowSchedulingOutputHandler;
import org.workflow.scheduling.pool.WorkflowSchedulingPool;

/**
 * Scheduling Engine that drives the steps.
 */
public final class WorkflowSchedulingEngine {

	private WorkflowPriorityCalculator scheduler;
	private WorkflowSchedulingPool pool;
	private WorkflowSchedulingOutputHandler outputHandler;

	private static final int SCHED_BALANCE_ROTATOR = 17;

	/**
	 * Constructor.
	 * 
	 * @param scheduler
	 *            that decides orders of workflows.
	 * @param pool
	 *            that contains current READY workflows.
	 * @param outputHandler
	 *            takes next READY workflow and sends it for execution.
	 */
	public WorkflowSchedulingEngine(final WorkflowPriorityCalculator scheduler, final WorkflowSchedulingPool pool,
			final WorkflowSchedulingOutputHandler outputHandler) {
		this.scheduler = scheduler;
		this.pool = pool;
		this.outputHandler = outputHandler;
	}

	/**
	 * Start point for scheduling flow.
	 */
	public void start() {
		(new AddInputs()).run();
		// (new WFExecutor()).run();
	}

	/**
	 * Thread that dynamically adds workflow to pool.
	 */
	class AddInputs implements Runnable {

		StringBuffer sb = new StringBuffer();

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				BaseClusterSimWorkflow bcw = scheduler.getNextWorkflow();
				if (bcw != null) {
					pool.addToPool(bcw);

					sb.append("Current workflow is ").append(bcw.getWorkflowName()).append("; The priority is ")
							.append(bcw.getSchedulingPriority().getPriorityIndex()).append("; Scheduling Pool size is ")
							.append(pool.getPoolSize());

					System.out.println(sb.toString());
					sb.delete(0, sb.length() - 1);
				}
			}
		}
	}

	/**
	 * Thread that handles next READY workflow.
	 */
	class WFExecutor implements Runnable {

		long seq_id = 0;
		Random ran = new Random();

		@Override
		public void run() {
			while (true) {
				System.out.println("I am running2");
				long curPriorityIndex;
				if ((++seq_id) / SCHED_BALANCE_ROTATOR != 0) {
					curPriorityIndex = 0;
				} else {
					curPriorityIndex = SCHED_BALANCE_ROTATOR + ran.nextLong();
				}
				boolean foundNextWF = false;
				while (!foundNextWF) {
					SchedulingPriority sp = new SchedulingPriority(curPriorityIndex);
					if (pool.poolContainsWF(sp)) {
						foundNextWF = true;
						outputHandler.execute(pool.retrieveNextWorkflow(sp));
					} else {
						curPriorityIndex++;
					}
				}
			}
		}

	}

	/**
	 * Daemon thread for re-scheduling workflows in READY pool.
	 * 
	 * TODO: implementation.
	 *
	 */
	class DaemonReScheduling implements Runnable {

		@Override
		public void run() {
			// TODO Auto-generated method stub

		}

	}
}
