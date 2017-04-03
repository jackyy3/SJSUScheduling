package org.workflow.scheduling.comparator;

import java.util.Comparator;

import org.workflow.scheduling.Workflow;

public interface WorkflowComparator<T> extends Comparator<Workflow> {
    String getComparisonField();
}
