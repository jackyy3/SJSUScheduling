package org.workflow.scheduling.engine;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

public enum WorkflowLoader {
	INSTANCE;
	
	public List<String> getWorkflowPaths(final String parentPath){
		File dir = new File(parentPath);
		File[] files = dir.listFiles();
		List<String> paths = new ArrayList<>();
		for(File f : files){
			paths.add(f.getAbsolutePath());
		}
		return paths;
	}
}
