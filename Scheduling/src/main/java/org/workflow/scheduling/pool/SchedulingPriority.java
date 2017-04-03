package org.workflow.scheduling.pool;

/**
 * Priority definition.
 */
public class SchedulingPriority {

	private long priorityIndex;

	/**
	 * Constructor.
	 * 
	 * @param priorityIndex
	 */
	public SchedulingPriority(final long priorityIndex) {
		this.setPriorityIndex(priorityIndex);
	}

	/**
	 * @return the priorityIndex
	 */
	public long getPriorityIndex() {
		return priorityIndex;
	}

	/**
	 * @param priorityIndex
	 *            the priorityIndex to set
	 */
	public void setPriorityIndex(long priorityIndex) {
		this.priorityIndex = priorityIndex;
	}

	@Override
	public boolean equals(final Object o) {
		SchedulingPriority s = (SchedulingPriority) o;
		if (this.priorityIndex == s.getPriorityIndex()) {
			return true;
		}
		return false;
	}
}
