package org.workflow.scheduling.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.workflow.process.ExecutionResult.ExecutionStatus;
import org.workflow.process.Result;
import org.workflow.scheduling.BaseClusterSimWorkflow;
import org.workflow.scheduling.engine.SimResult.SimResultBuilder;
import org.workflow.scheduling.pool.SchedulingPriority;
import org.workflow.scheduling.pool.WorkflowPriorityCalculator;
import org.workflow.scheduling.pool.WorkflowSchedulingOutputHandler;
import org.workflow.scheduling.pool.WorkflowSchedulingPool;

/**
 * Scheduling Engine that drives the steps.
 */
public final class WorkflowSchedulingEngine2 {

	private WorkflowPriorityCalculator scheduler;
	private WorkflowSchedulingPool pool;
	private WorkflowSchedulingOutputHandler outputHandler;

//	private ExecutorService executorService = new ThreadPoolExecutor(50, 50, Long.MAX_VALUE, TimeUnit.MILLISECONDS,
//			new ArrayBlockingQueue(50));
	private List<Result<BaseClusterSimWorkflow>> results = new ArrayList<Result<BaseClusterSimWorkflow>>();

	private static final int SCHED_BALANCE_ROTATOR = 17;

	private int POOL_SIZE;
	private int POOL_STATUS;

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
	public WorkflowSchedulingEngine2(final WorkflowPriorityCalculator scheduler, final WorkflowSchedulingPool pool,
			final WorkflowSchedulingOutputHandler outputHandler, final int POOL_SIZE, final int POOL_STATUS) {
		this.scheduler = scheduler;
		this.pool = pool;
		this.outputHandler = outputHandler;
		this.POOL_SIZE = POOL_SIZE;
		this.POOL_STATUS = POOL_STATUS;
	}

	/**
	 * Start point for scheduling flow.
	 */
	public SimResult start() {
		SimResultBuilder srb = new SimResultBuilder();
		List<Long> durations = new ArrayList<Long>();
		List<Long> tardinesses = new ArrayList<Long>();
		srb.overallStartTime(System.currentTimeMillis());
		(new AddInputs()).run();
		srb.overallCompletionTime(System.currentTimeMillis());
		for(Result<BaseClusterSimWorkflow> r : results){
			durations.add(r.getLifeTimeDuration());
			tardinesses.add(r.getTardiness());
		}
		srb.duration(durations);
		srb.tardiness(tardinesses);
		srb.executionStatus(ExecutionStatus.SUCCESSFUL);
		return srb.build();
	}

	/**
	 * Start point for scheduling flow.
	 */
	public SimResult start(final int PoolSize) {
		this.POOL_SIZE = PoolSize;
		SimResultBuilder srb = new SimResultBuilder();
		List<Long> durations = new ArrayList<Long>();
		List<Long> tardinesses = new ArrayList<Long>();
		srb.overallStartTime(System.currentTimeMillis());
		(new AddInputs()).run();
		srb.overallCompletionTime(System.currentTimeMillis());
		for(Result<BaseClusterSimWorkflow> r : results){
			durations.add(r.getLifeTimeDuration());
			tardinesses.add(r.getTardiness());
		}
		srb.duration(durations);
		srb.tardiness(tardinesses);
		srb.executionStatus(ExecutionStatus.SUCCESSFUL);
		return srb.build();
	}

	/**
	 * Thread that dynamically adds workflow to pool.
	 */
	class AddInputs implements Runnable {

		StringBuffer sb = new StringBuffer();
		Random ran = new Random();
		int count = 0;

		@Override
		public void run() {
			while (true && count < POOL_SIZE) {
				try {
					Thread.sleep(ran.nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				BaseClusterSimWorkflow bcw = scheduler.getNextWorkflow();
				if (bcw != null) {
					bcw.setArrivalTime(System.currentTimeMillis());
					pool.addToPool(bcw);

					// sb.append("Current workflow is
					// ").append(bcw.getWorkflowName()).append("; The priority
					// is ")
					// .append(bcw.getSchedulingPriority().getPriorityIndex()).append(";
					// Scheduling Pool size is ")
					// .append(pool.getPoolSize());

					// System.out.println(sb.toString());
					// sb.delete(0, sb.length());
					count++;
					if(POOL_STATUS != 0){
						if ((ran.nextInt(1000) / 7) % 2 == 0) {
							(new WFExecutor(ran.nextInt(100))).run();
						}
					}
					// outputHandler.execute(bcw);
				}
			}
			(new WFExecutor(POOL_SIZE)).run();
		}
	}

	/**
	 * Thread that handles next READY workflow.
	 */
	class WFExecutor implements Runnable {

		long seq_id = 0;
		Random ran = new Random();
		long limit = Long.MAX_VALUE;
		long counter = 0;

		public void setLimit(final long limit) {
			this.limit = limit;
		}

		public WFExecutor() {
			this.limit = Long.MAX_VALUE;
		}

		public WFExecutor(final long limit) {
			this.limit = limit;
		}

		@Override
		public void run() {
			 counter = 0;
			while (true && (counter < limit)) {
				counter++;
				long counter2 = 0;
				long curPriorityIndex;
				if ((++seq_id) / SCHED_BALANCE_ROTATOR != 0) {
					curPriorityIndex = 0;
				} else {
					curPriorityIndex = 0;// SCHED_BALANCE_ROTATOR +
											// ran.nextLong();
				}
				boolean foundNextWF = false;
				while (!foundNextWF && (counter2 < 100000)) {
					counter2++;
					SchedulingPriority sp = new SchedulingPriority(curPriorityIndex);
					if (pool.poolContainsWF(sp)) {
						foundNextWF = true;
						results.add(outputHandler.execute(pool.retrieveNextWorkflow(sp)));
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

