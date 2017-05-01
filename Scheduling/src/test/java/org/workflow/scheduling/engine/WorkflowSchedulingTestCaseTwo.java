package org.workflow.scheduling.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import org.junit.Test;

public class WorkflowSchedulingTestCaseTwo {

	private ExecutorService executorService = new ThreadPoolExecutor(50, 50, Long.MAX_VALUE, TimeUnit.MILLISECONDS,
			new ArrayBlockingQueue(50));

	@Test
	public void testSchedulingFlowParallel() {
		int[] sizes = { 1000, 1500, 2000, 2500 };
		int[] poolStatus = { 0, 1 };

		List<Future> futures = new ArrayList<Future>();

		for (int p : poolStatus) {
			for (int s : sizes) {
				WorkflowSchedulingTestCaseTwoCallable wstctc = new WorkflowSchedulingTestCaseTwoCallable(s, p);
				futures.add(executorService.submit(wstctc));
			}
		}

		for (Future f : futures) {
			System.out.println(f.toString());
		}
	}
}
