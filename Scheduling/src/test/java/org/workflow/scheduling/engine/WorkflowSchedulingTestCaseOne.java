package org.workflow.scheduling.engine;

import org.junit.Test;
import org.workflow.scheduling.algorithms.WorkflowSchedulingAlgorithmType;
import org.workflow.scheduling.pool.InputStreamingListener;
import org.workflow.scheduling.pool.WorkflowPriorityCalculator;
import org.workflow.scheduling.pool.WorkflowSchedulingOutputHandler;
import org.workflow.scheduling.pool.WorkflowSchedulingPool;

public class WorkflowSchedulingTestCaseOne {

	@Test
	public void testSchedulingFlow() {
		WorkflowSchedulingOutputHandler handler = new WorkflowSchedulingOutputHandler();
		WorkflowSchedulingPool pool = new WorkflowSchedulingPool();
		WorkflowPriorityCalculator calculator = new WorkflowPriorityCalculator(WorkflowSchedulingAlgorithmType.EDF,
				new InputStreamingListener());

		WorkflowSchedulingEngine engine = new WorkflowSchedulingEngine(calculator, pool, handler);

		engine.start();
	}

}
