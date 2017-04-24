package org.workflow.scheduling.adapter;

import org.workflow.Task;

public class GenericTaskAdapter extends AbstractAdapter<org.sjsu.wfs.workflow.Task, Task> {

	public GenericTaskAdapter(org.sjsu.wfs.workflow.Task s) {
		super(s);
	}

	@Override
	public Task adapt() {
		return null;
	}

}
