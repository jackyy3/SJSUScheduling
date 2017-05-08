package org.workflow.scheduling.engine;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.sjsu.wfs.workflow.generation.StaticWorkflowFactory;
import org.workflow.process.RealTimeWorkflowProcessor;
import org.workflow.scheduling.algorithms.WorkflowSchedulingAlgorithmType;
import org.workflow.scheduling.pool.InputStreamingListener;
import org.workflow.scheduling.pool.WorkflowPriorityCalculator;
import org.workflow.scheduling.pool.WorkflowSchedulingOutputHandler;
import org.workflow.scheduling.pool.WorkflowSchedulingPool;

public class WorkflowSchedulingTestCaseOne {

	@Test
	public void testSchedulingFlow() throws IOException {

		int[] sizes = { 50, 25};
		int[] poolStatus = { 0, 1};

		for (int p : poolStatus) {

			SimulationConfig.INSTANCE.setPoolStatus(p);
			String ps;
			if (p == 0) {
				ps = "Static";
			} else {
				ps = "Dynamic";
			}

			for (int s : sizes) {

				String filePath = "/Users/zxing/git_4/SJSUScheduling/Scheduling/workflows/" + String.valueOf(s * 100)
						+ "pool/";

				WorkflowSchedulingOutputHandler handler = new WorkflowSchedulingOutputHandler(
						new RealTimeWorkflowProcessor());
				WorkflowSchedulingPool pool = new WorkflowSchedulingPool();
				WorkflowPriorityCalculator calculator = new WorkflowPriorityCalculator(
						WorkflowSchedulingAlgorithmType.EDF,
						new InputStreamingListener(new StaticWorkflowFactory(filePath)));

				WorkflowSchedulingEngine2 engine = new WorkflowSchedulingEngine2(calculator, pool, handler, s, p);

				SimResult sr = engine.start(s);
				//SimResult sr = engine.start();
				List<Long> tardinesses = sr.getTardiness();
				List<Long> durations = sr.getDuration();
				long overallDuration = sr.getTotalDuration();

				// TODO: use StringBuilder
				String fileName_tardiness = "TestResult/" + String.valueOf(s) + "_" + ps + "_tardiness.txt";
				String fileName_duration = "TestResult/" + String.valueOf(s) + "_" + ps + "_duration.txt";
				String fileName_total = "TestResult/" + String.valueOf(s) + "_" + ps + "_total.txt";

				File file_tardiness = new File(fileName_tardiness);
				File file_duration = new File(fileName_duration);
				File file_total = new File(fileName_total);

				FileWriter fw_tardiness = new FileWriter(file_tardiness, false);
				for (Long lt : tardinesses) {
					fw_tardiness.write(String.valueOf(lt) + "\n");
				}

				FileWriter fw_duration = new FileWriter(file_duration, false);
				for (Long ld : durations) {
					fw_duration.write(String.valueOf(ld) + "\n"); // TODO: use
																	// //
																	// StringBuilder
				}

				FileWriter fw_total = new FileWriter(file_total, false);
				fw_total.write(String.valueOf(overallDuration)); // TODO: use
																	// StringBuilder

				System.out.println("All good_" + String.valueOf(s) + "-" + ps);
				fw_tardiness.close();
				fw_duration.close();
				fw_total.close();
			}
		}
		System.out.println("All good");
	}

	@Test
	public void testConfig() {
		SimulationConfig.INSTANCE.setPoolStatus(1);
		Assert.assertTrue(SimulationConfig.INSTANCE.getPoolStatus() == 1);
		SimulationConfig.INSTANCE.setPoolStatus(0);
		Assert.assertTrue(SimulationConfig.INSTANCE.getPoolStatus() == 0);
	}
}
