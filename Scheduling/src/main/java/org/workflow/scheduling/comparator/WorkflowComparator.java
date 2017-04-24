package org.workflow.scheduling.comparator;

import java.util.Comparator;

import org.workflow.scheduling.ClusterSimWorkflow;

public interface WorkflowComparator<T> extends Comparator<ClusterSimWorkflow> {
    String getComparisonField();
}
