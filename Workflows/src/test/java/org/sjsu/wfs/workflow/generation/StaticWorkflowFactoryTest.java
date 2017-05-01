package org.sjsu.wfs.workflow.generation;

import org.junit.Test;
import org.sjsu.wfs.workflow.Workflow;

public class StaticWorkflowFactoryTest {
	@Test
	public void testWorkflowGen(){
		StaticWorkflowFactory swf = new StaticWorkflowFactory("/Users/zxing/git_4/SJSUScheduling/Workflows/workflows");
		Workflow wf = swf.createSingleWorkflow("/Users/zxing/git_4/SJSUScheduling/Workflows/workflows/Workflow_1.xml");
		System.out.println(wf.toString());
	}
}
