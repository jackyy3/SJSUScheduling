package org.workflow.scheduling.comparator;

import org.workflow.scheduling.BaseClusterSimWorkflow;
import org.workflow.scheduling.ClusterSimWorkflow;

public class DeadlineComparator implements WorkflowComparator<ClusterSimWorkflow> {

	public static final String COMPARISONFIELD = "Deadline";
	
	@Override
	public int compare(ClusterSimWorkflow o1, ClusterSimWorkflow o2) {
		BaseClusterSimWorkflow bo1 = (BaseClusterSimWorkflow) o1;
		BaseClusterSimWorkflow bo2 = (BaseClusterSimWorkflow) o2;
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
