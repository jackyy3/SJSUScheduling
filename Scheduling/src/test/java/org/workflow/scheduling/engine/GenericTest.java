package org.workflow.scheduling.engine;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

import org.junit.Test;
import org.sjsu.wfs.workflow.generation.RandomWorkflowFactory;
import org.sjsu.wfs.workflow.generation.StaticWorkflowFactory;
import org.sjsu.wfs.workflow.generation.WorkflowFactory;
import org.sjsu.wfs.workflow.generation.WorkflowFileGenerator;
import org.workflow.process.RealTimeWorkflowProcessor;
import org.workflow.scheduling.algorithms.WorkflowSchedulingAlgorithmType;
import org.workflow.scheduling.pool.InputStreamingListener;
import org.workflow.scheduling.pool.WorkflowPriorityCalculator;
import org.workflow.scheduling.pool.WorkflowSchedulingOutputHandler;
import org.workflow.scheduling.pool.WorkflowSchedulingPool;

public class GenericTest {
	
	@Test
	public void generateStaticWorkflowPool(){
		String filePath = "workflows/";
		List<String> paths = WorkflowLoader.INSTANCE.getWorkflowPaths(filePath);
		WorkflowFactory wfF = new RandomWorkflowFactory();
		WorkflowFileGenerator wg = new WorkflowFileGenerator(wfF);
		int mod = paths.size();
		int i = 2000;
		while(i > 0){
			wg.produceSingleWorkflow("2000pool", paths.get(i % mod));
			i--;
		}
	}
	
	@Test
	public void testEntireFlow() throws InterruptedException{
		WorkflowSchedulingOutputHandler handler = new WorkflowSchedulingOutputHandler(
				new RealTimeWorkflowProcessor());
		WorkflowSchedulingPool pool = new WorkflowSchedulingPool();
		WorkflowPriorityCalculator calculator = new WorkflowPriorityCalculator(
				WorkflowSchedulingAlgorithmType.EDF,
				new InputStreamingListener(new RandomWorkflowFactory()));

		WorkflowSchedulingEngine engine = new WorkflowSchedulingEngine(calculator, pool, handler);

		SimResult sr = engine.start();
		List<Long> tardinesses = sr.getTardiness();
		List<Long> durations = sr.getDuration();
		long ovarallDurartion = sr.getTotalDuration();
		long completionTime = sr.getOverallCompletionTime();
		long startime = sr.getOverallStartTime();
		System.out.println("Number of tasks executed " + String.valueOf(tardinesses.size()));
		System.out.println("Total duration is " + String.valueOf(ovarallDurartion) + " in miliseconds");

		//System.out.println(sr.toString());
	}
}
