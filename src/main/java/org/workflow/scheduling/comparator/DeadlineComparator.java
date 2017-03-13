package org.workflow.scheduling.comparator;

import org.workflow.scheduling.BaseWorkflow;
import org.workflow.scheduling.Workflow;

public class DeadlineComparator implements WorkflowComparator<Workflow> {

	public static final String COMPARISONFIELD = "Deadline";
	
	@Override
	public int compare(Workflow o1, Workflow o2) {
		BaseWorkflow bo1 = (BaseWorkflow) o1;
		BaseWorkflow bo2 = (BaseWorkflow) o2;
		if (bo1.getDeadline() < bo2.getDeadline()) {
			return -1;
		} else if (bo1.getDeadline() > bo2.getDeadline()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String getComparisonField() {
		return COMPARISONFIELD;
	}

}
