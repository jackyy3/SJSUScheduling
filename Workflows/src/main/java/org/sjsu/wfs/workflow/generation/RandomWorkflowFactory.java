package org.sjsu.wfs.workflow.generation;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.sjsu.wfs.workflow.CostModelDefinition;
import org.sjsu.wfs.workflow.Task;
import org.sjsu.wfs.workflow.TaskContainer;
import org.sjsu.wfs.workflow.Workflow;
import org.sjsu.wfs.workflow.WorkflowType;
import org.sjsu.wfs.workflow.util.WorkflowBuilder;

public class RandomWorkflowFactory implements WorkflowFactory {

	private Random ran = new Random();

	public RandomWorkflowFactory() {
	}

	@Override
	public Workflow createSingleWorkflow() {

		return this.createSingleWorkflow(null);
	}

	@Override
	public List<Workflow> createWorkflows(final int numberOfWfs) {
		List<Workflow> wfs = new ArrayList<>(numberOfWfs);
		for (int i = 0; i < numberOfWfs; i++) {
			wfs.add(this.createSingleWorkflow());
		}
		return wfs;
	}

	private int getNextRandomNumber(final int max) {
		return ran.nextInt(max);
	}

	@Override
	public Workflow createSingleWorkflow(String filePath) {
		int typeIndex = this.getNextRandomNumber(100);
		WorkflowType workflowType = WorkflowType.SEQUENTIAL;
		if (typeIndex % 3 == 0) {
			workflowType = WorkflowType.FULLY_PARALLEL;
		} else if (typeIndex % 3 == 1) {
			workflowType = WorkflowType.PARTIAL_PARALLEL;
		}
		WorkflowBuilder wb = new WorkflowBuilder(workflowType);
		String workflowId = wb.getWorkflowId();
		wb.inputFilePath(filePath);
		wb.costModel(new CostModelDefinition(this.getNextRandomNumber(10000)));
		// wb.estimatedDuration(this.getNextRandomNumber(100000) + 1000);
		String workflowName = (new StringBuilder("Workflow_")).append(workflowId).toString();
		wb.workflowName(workflowName);
		wb.deadline(System.currentTimeMillis() + this.getNextRandomNumber(Integer.MAX_VALUE));
		long totalSize = 0;
		long estimatedWorkflowDuration = 0;
		int numberOfTasks = this.getNextRandomNumber(10);
		TaskContainer tc = new TaskContainer();
		for (int i = 0; i < numberOfTasks; i++) {
			Task newTask = new Task();
			newTask.setName((new StringBuilder(workflowName)).append("_Task_").append(i).toString());
			newTask.setTaskId(i);
			long estimatedDuration = this.getNextRandomNumber(1000);
			estimatedWorkflowDuration += estimatedDuration;
			long newTaskSize = this.getNextRandomNumber(10000);
			totalSize += newTaskSize;
			newTask.setEstimatedDuration(estimatedDuration);
			newTask.setTaskSize(newTaskSize);
			tc.addTask(newTask);
		}
		wb.tasksContainer(tc);
		wb.totalSize(totalSize);
		wb.numberOfTasks(numberOfTasks);
		wb.estimatedDuration(estimatedWorkflowDuration + this.getNextRandomNumber(100));
		return wb.build();
	}

	@Override
	public List<Workflow> createWorkflows(String[] filePaths) {
		List<Workflow> wfs = new ArrayList<>(filePaths.length);
		for (String filePath : filePaths) {
			wfs.add(this.createSingleWorkflow(filePath));
		}
		return wfs;
	}

}
