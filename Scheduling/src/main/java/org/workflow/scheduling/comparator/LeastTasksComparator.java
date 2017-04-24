package org.workflow.scheduling.comparator;

import org.workflow.scheduling.BaseClusterSimWorkflow;
import org.workflow.scheduling.ClusterSimWorkflow;

public class LeastTasksComparator implements WorkflowComparator<ClusterSimWorkflow> {

	public static final String COMPARISONFIELD = "ChildrenNumber";
	
	@Override
	public int compare(ClusterSimWorkflow o1, ClusterSimWorkflow o2) {
		BaseClusterSimWorkflow bo1 = (BaseClusterSimWorkflow) o1;
		BaseClusterSimWorkflow bo2 = (BaseClusterSimWorkflow) o2;
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
