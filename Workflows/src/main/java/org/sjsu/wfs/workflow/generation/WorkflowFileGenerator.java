package org.sjsu.wfs.workflow.generation;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import org.sjsu.wfs.workflow.Workflow;

public class WorkflowFileGenerator {

	private WorkflowFactory workflowFactory;

	public WorkflowFileGenerator(final WorkflowFactory workflowFactory) {
		this.workflowFactory = workflowFactory;
	}

	public List<Workflow> produceWorkflows() {
		List<Workflow> workflows = workflowFactory.createWorkflows(100);
		return workflows;
	}

	public List<String> produceWorkflowFiles() {
		List<Workflow> workflows = this.produceWorkflows();
		List<String> fileNames = new ArrayList<>();
		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(Workflow.class);
			Marshaller jaxbMarshaller = jaxbContext.createMarshaller();
			// output pretty printed
			jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);

			for (Workflow wf : workflows) {
				String fileName = wf.getName();
				File file = new File("workflows/" + fileName);
				fileNames.add(file.getAbsolutePath());

				jaxbMarshaller.marshal(wf, file);
				jaxbMarshaller.marshal(wf, System.out);
			}

		} catch (JAXBException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return fileNames;
	}

}
