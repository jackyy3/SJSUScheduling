package org.sjsu.wfs.workflow.generation;

import java.util.List;

import org.sjsu.wfs.workflow.Workflow;

public interface WorkflowFactory {

	Workflow createSingleWorkflow();
	
	Workflow createSingleWorkflow(String filePath);

	List<Workflow> createWorkflows(int numberOfWfs);
	
	List<Workflow> createWorkflows(String[] filePaths);
}
