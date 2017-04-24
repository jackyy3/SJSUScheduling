package org.workflow.scheduling.comparator;

import org.workflow.scheduling.BaseClusterSimWorkflow;
import org.workflow.scheduling.ClusterSimWorkflow;

public class ArrivalTimeComparator implements WorkflowComparator<ClusterSimWorkflow> {

	public static final String COMPARISONFIELD = "ArrivalTime";

	@Override
	public int compare(ClusterSimWorkflow o1, ClusterSimWorkflow o2) {
		BaseClusterSimWorkflow bo1 = (BaseClusterSimWorkflow) o1;
		BaseClusterSimWorkflow bo2 = (BaseClusterSimWorkflow) o2;
		if (bo1.getArrivalTime() < bo2.getArrivalTime()) {
			return -1;
		} else if (bo1.getArrivalTime() > bo2.getArrivalTime()) {
			return 1;
		}
		return 0;
	}

	@Override
	public String getComparisonField() {
		return COMPARISONFIELD;
	}
}