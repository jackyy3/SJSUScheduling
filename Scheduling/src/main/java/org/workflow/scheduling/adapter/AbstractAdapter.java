package org.workflow.scheduling.adapter;

public abstract class AbstractAdapter<S, T> {

	protected S s;

	public AbstractAdapter(final S s) {
		this.s = s;
	}

	public abstract T adapt();

	public S getSource() {
		return this.s;
	}
}
