package org.workflow.scheduling.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

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
public final class WorkflowSchedulingEngine {

	private WorkflowPriorityCalculator scheduler;
	private WorkflowSchedulingPool pool;
	private WorkflowSchedulingOutputHandler outputHandler;

	private ExecutorService executorService = Executors.newFixedThreadPool(10);
	private List<Result<BaseClusterSimWorkflow>> results = new ArrayList<Result<BaseClusterSimWorkflow>>();

	private static final int SCHED_BALANCE_ROTATOR = 17;

	private int POOL_SIZE = 10000;

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
	public SimResult start() {

		SimResultBuilder srb = new SimResultBuilder();
		List<Long> durations = new ArrayList<Long>();
		List<Long> tardinesses = new ArrayList<Long>();
		srb.overallStartTime(System.currentTimeMillis());
		
		Future<?> processor = executorService.submit(new WFExecutor(10000));
		Future<?> scheduler_1 = executorService.submit(new AddInputs());
		Future<?> scheduler_2 = executorService.submit(new AddInputs());
		Future<?> scheduler_3 = executorService.submit(new AddInputs());
		Future<?> scheduler_4 = executorService.submit(new AddInputs());
		Future<?> scheduler_5 = executorService.submit(new AddInputs());
		Future<?> scheduler_6 = executorService.submit(new AddInputs());
		Future<?> scheduler_7 = executorService.submit(new AddInputs());
		Future<?> scheduler_8 = executorService.submit(new AddInputs());
		Future<?> scheduler_9 = executorService.submit(new AddInputs());
		Future<?> scheduler_10 = executorService.submit(new AddInputs());
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		scheduler_1.cancel(true);
		scheduler_2.cancel(true);
		scheduler_3.cancel(true);
		scheduler_4.cancel(true);
		scheduler_5.cancel(true);
		scheduler_6.cancel(true);
		scheduler_7.cancel(true);
		scheduler_8.cancel(true);
		scheduler_9.cancel(true);
		scheduler_10.cancel(true);
		
		try {
			Thread.sleep(20000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		srb.overallCompletionTime(System.currentTimeMillis());
		for(Result<BaseClusterSimWorkflow> r : results){
			durations.add(r.getLifeTimeDuration());
			tardinesses.add(r.getTardiness());
		}
		srb.duration(durations);
		srb.tardiness(tardinesses);
		srb.executionStatus(ExecutionStatus.SUCCESSFUL);
		srb.future(processor);
		
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

		//global
		Random ran = new Random();

		@Override
		public void run() {
			while (true) {
				try {
					Thread.sleep(2000+ran.nextInt(1000));
				} catch (InterruptedException e) {
					try {
						this.wait();
					} catch (InterruptedException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
				BaseClusterSimWorkflow bcw = scheduler.getNextWorkflow();
				System.out.println("I am a new input, current pool size is " + String.valueOf(pool.getPoolSize()));
				if (bcw != null) {
					bcw.setArrivalTime(System.currentTimeMillis());
					pool.addToPool(bcw);
				}
			}
		}
	}

	/**
	 * Thread that handles next READY workflow.
	 */
	class WFExecutor implements Runnable {

		long seq_id = 0;
		//global
		Random ran = new Random();
		long limit = Long.MAX_VALUE;
		

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
			while (true) {
				try {
					Thread.sleep(ran.nextInt(1000));
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				long curPriorityIndex;
				if ((++seq_id) / SCHED_BALANCE_ROTATOR != 0) {
					curPriorityIndex = 0;
				} else {
					curPriorityIndex = SCHED_BALANCE_ROTATOR + ran.nextInt(100);
				}
				boolean foundNextWF = false;
				while (!foundNextWF && curPriorityIndex < 10000) {
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
