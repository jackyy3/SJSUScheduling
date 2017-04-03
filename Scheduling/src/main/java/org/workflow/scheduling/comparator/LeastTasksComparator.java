package org.workflow.scheduling.comparator;

import org.workflow.scheduling.BaseWorkflow;
import org.workflow.scheduling.Workflow;

public class LeastTasksComparator implements WorkflowComparator<Workflow> {

	public static final String COMPARISONFIELD = "ChildrenNumber";
	
	@Override
	public int compare(Workflow o1, Workflow o2) {
		BaseWorkflow bo1 = (BaseWorkflow) o1;
		BaseWorkflow bo2 = (BaseWorkflow) o2;
		if (bo1.getTasks().size() < bo2.getTasks().size()) {
			return -1;
		} else if (bo1.getTasks().size() > bo2.getTasks().size()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String getComparisonField() {
		return COMPARISONFIELD;
	}

}
