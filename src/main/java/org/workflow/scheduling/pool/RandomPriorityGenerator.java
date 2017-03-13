package org.workflow.scheduling.pool;

import java.util.Random;

/**
 * Generates random priority for testing purpose.
 */
public final class RandomPriorityGenerator {

	public SchedulingPriority generateRandomPriorityIndex() {
		Random ranNum = new Random();
		return new SchedulingPriority(ranNum.nextLong());
	}
}
