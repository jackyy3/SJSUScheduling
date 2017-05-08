package org.workflow.scheduling.engine;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

import org.junit.Test;

public class WorkflowSchedulingTestCaseTwo {

	private ExecutorService executorService = Executors.newFixedThreadPool(4);

	@Test
	public void testSchedulingFlowParallel() {
		int[] sizes = { 1000, 1500, 2000, 2500 };
		int[] poolStatus = { 0, 1 };

		List<Future> futures = new ArrayList<Future>();

		for (int p : poolStatus) {
			for (int s : sizes) {
				WorkflowSchedulingTestCaseTwoCallable wstctc = new WorkflowSchedulingTestCaseTwoCallable(s, p);
				Future future = executorService.submit(wstctc);
				futures.add(future);
			}
		}

		for (Future f : futures) {
			System.out.println(f.toString());
		}
	}
}
