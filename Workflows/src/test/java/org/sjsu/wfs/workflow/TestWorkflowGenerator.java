package org.sjsu.wfs.workflow;

import java.util.List;

import org.junit.Test;
import org.sjsu.wfs.workflow.generation.RandomWorkflowFactory;
import org.sjsu.wfs.workflow.generation.WorkflowFactory;
import org.sjsu.wfs.workflow.generation.WorkflowFileGenerator;

public class TestWorkflowGenerator {

	@Test
	public void testGenerate() {
		
		WorkflowFactory wfF = new RandomWorkflowFactory();
		WorkflowFileGenerator wg = new WorkflowFileGenerator(wfF);
		List<String> filenames = wg.produceWorkflowFiles();
		for(String s : filenames){
			System.out.println(s);
		}
	}
}
