package org.workflow.scheduling.engine;

import java.util.List;

import org.junit.Test;
import org.sjsu.wfs.workflow.generation.RandomWorkflowFactory;
import org.sjsu.wfs.workflow.generation.WorkflowFactory;
import org.sjsu.wfs.workflow.generation.WorkflowFileGenerator;

public class GenericTest {
	
	@Test
	public void generateStaticWorkflowPool(){
		String filePath = "workflows/";
		List<String> paths = WorkflowLoader.INSTANCE.getWorkflowPaths(filePath);
		WorkflowFactory wfF = new RandomWorkflowFactory();
		WorkflowFileGenerator wg = new WorkflowFileGenerator(wfF);
		int mod = paths.size();
		int i = 5000;
		while(i > 0){
			wg.produceSingleWorkflow("5000Pool", paths.get(i % mod));
			i--;
		}
	}
}
