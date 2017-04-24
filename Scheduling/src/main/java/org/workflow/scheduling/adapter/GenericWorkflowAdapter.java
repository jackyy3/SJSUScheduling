package org.workflow.scheduling.adapter;

import java.util.ArrayList;
import java.util.List;

import org.sjsu.wfs.workflow.Workflow;
import org.workflow.Task;
import org.workflow.scheduling.BaseClusterSimWorkflow;
import org.workflow.scheduling.ClusterSimWorkflow;

public class GenericWorkflowAdapter extends AbstractAdapter<Workflow, ClusterSimWorkflow> {

	public GenericWorkflowAdapter(final Workflow workflow) {
		super(workflow);
	}

	@Override
	public ClusterSimWorkflow adapt() {
		if (s == null) {
			return null;
		}
		BaseClusterSimWorkflow baseClusterWorkflow = new BaseClusterSimWorkflow(s.getWorkflowId());
		baseClusterWorkflow.setDataPath(s.getInputFilePath());
		baseClusterWorkflow.setDeadline(s.getDeadline());
		baseClusterWorkflow.setEstimatedDuration(s.getEstimatedDuration());
		baseClusterWorkflow.setSimpleMissingDeadlineCost(s.getCostModel().getCost());
		baseClusterWorkflow.setTotalSize(s.getTotalSize());
		baseClusterWorkflow.setWorkflowType(s.getWorkflowType());
		baseClusterWorkflow.setWorkflowName(s.getName());
		//TODO: add adapter logics from generic task to simulation task.
		List<Task> tasks = new ArrayList<Task>((int) s.getNumberOfTasks());
		baseClusterWorkflow.setTasks(tasks);
		return baseClusterWorkflow;
	}

}
