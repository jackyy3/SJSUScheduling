package org.workflow.scheduling.engine;

public enum SimulationConfig {
	INSTANCE;

	private int poolStatus; // 0-static, 1 or others - dynamic

//	private SimulationConfig(final int poolStatus) {
//		this.poolStatus = poolStatus;
//	}

	public synchronized void setPoolStatus(final int poolStatus) {
		this.poolStatus = poolStatus;
	}

	public synchronized int getPoolStatus() {
		return this.poolStatus;
	}
}
