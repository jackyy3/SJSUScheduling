package org.workflow.scheduling.engine;

import java.io.File;
import java.io.FileWriter;
import java.util.List;
import java.util.concurrent.Callable;

import org.sjsu.wfs.workflow.generation.StaticWorkflowFactory;
import org.workflow.process.RealTimeWorkflowProcessor;
import org.workflow.scheduling.algorithms.WorkflowSchedulingAlgorithmType;
import org.workflow.scheduling.pool.InputStreamingListener;
import org.workflow.scheduling.pool.WorkflowPriorityCalculator;
import org.workflow.scheduling.pool.WorkflowSchedulingOutputHandler;
import org.workflow.scheduling.pool.WorkflowSchedulingPool;

public class WorkflowSchedulingTestCaseTwoCallable implements Callable {

	private int s;
	private int p;

	public WorkflowSchedulingTestCaseTwoCallable(final int s, final int p) {
		this.s = s;
		this.p = p;
	}

	@Override
	public Object call() throws Exception {
		String filePath = "/Users/zxing/git_4/SJSUScheduling/Scheduling/workflows/" + String.valueOf(s) + "pool/";

		WorkflowSchedulingOutputHandler handler = new WorkflowSchedulingOutputHandler(new RealTimeWorkflowProcessor());
		WorkflowSchedulingPool pool = new WorkflowSchedulingPool();
		WorkflowPriorityCalculator calculator = new WorkflowPriorityCalculator(WorkflowSchedulingAlgorithmType.EDF,
				new InputStreamingListener(new StaticWorkflowFactory(filePath)));

		WorkflowSchedulingEngine2 engine = new WorkflowSchedulingEngine2(calculator, pool, handler, s, p);

		SimResult sr = engine.start(s);
		List<Long> tardinesses = sr.getTardiness();
		List<Long> durations = sr.getDuration();
		long overallDuration = sr.getTotalDuration();

		String ps;
		if (p == 0) {
			ps = "Static";
		} else {
			ps = "Dynamic";
		}

		// TODO: use StringBuilder
		String fileName_tardiness = "TestResult2/" + String.valueOf(s) + "_" + ps + "_tardiness.txt";
		String fileName_duration = "TestResult2/" + String.valueOf(s) + "_" + ps + "_duration.txt";
		String fileName_total = "TestResult2/" + String.valueOf(s) + "_" + ps + "_total.txt";

		File file_tardiness = new File(fileName_tardiness);
		File file_duration = new File(fileName_duration);
		File file_total = new File(fileName_total);

		FileWriter fw_tardiness = new FileWriter(file_tardiness);
		for (Long lt : tardinesses) {
			fw_tardiness.write(String.valueOf(lt) + "\n");
		}

		FileWriter fw_duration = new FileWriter(file_duration);
		for (Long ld : durations) {
			fw_duration.write(String.valueOf(ld) + "\n"); // TODO: use
															// //
															// StringBuilder
		}

		FileWriter fw_total = new FileWriter(file_total);
		fw_total.write(String.valueOf(overallDuration)); // TODO: use
															// StringBuilder

		System.out.println("All good_" + String.valueOf(s) + "-" + String.valueOf(p));
		fw_tardiness.close();
		fw_duration.close();
		fw_total.close();
		return null;
	}

}
