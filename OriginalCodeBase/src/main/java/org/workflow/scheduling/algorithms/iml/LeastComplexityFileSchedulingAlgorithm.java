package org.workflow.scheduling.algorithms.iml;

import java.util.ArrayList;
import java.util.List;

import org.workflow.scheduling.algorithms.WorkflowSchedulingAlgorithmType;

public class LeastComplexityFileSchedulingAlgorithm implements WorkflowFileSchedulingAlgorithm {

	private WorkflowSchedulingAlgorithmType workflowSchedulingAlgorithmType;
	
	public LeastComplexityFileSchedulingAlgorithm(
			final WorkflowSchedulingAlgorithmType workflowSchedulingAlgorithmType){
		this.workflowSchedulingAlgorithmType = workflowSchedulingAlgorithmType;
	}
	
	@Override
	public WorkflowSchedulingAlgorithmType getWorkflowSchedulingAlgorithmType() {
		return this.workflowSchedulingAlgorithmType;
	}

	@Override
	public List<String> scheduleWorkflows(List<String> workflows) {
		List<String> daxPaths = new ArrayList<>();
        daxPaths.add("Montage_25.xml");
        daxPaths.add("Montage_50.xml");
		daxPaths.add("Montage_100.xml");
        daxPaths.add("Montage_1000.xml");
        daxPaths.add("Sipht_30.xml");
        daxPaths.add("Sipht_60.xml");
        daxPaths.add("Sipht_100.xml");
        daxPaths.add("Sipht_1000.xml");
        daxPaths.add("Inspiral_30.xml");
        daxPaths.add("Inspiral_50.xml");
        daxPaths.add("Inspiral_100.xml");
        daxPaths.add("Inspiral_1000.xml");
        daxPaths.add("CyberShake_30.xml");
        daxPaths.add("CyberShake_50.xml");
        daxPaths.add("CyberShake_100.xml");
        daxPaths.add("CyberShake_1000.xml");
        daxPaths.add("Epigenomics_24.xml");
        daxPaths.add("Epigenomics_46.xml");
        daxPaths.add("Epigenomics_100.xml");
        daxPaths.add("Epigenomics_997.xml");
		return daxPaths;
	}

}
