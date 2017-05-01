package org.sjsu.wfs.workflow.generation;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

import org.sjsu.wfs.workflow.ObjectFactory;
import org.sjsu.wfs.workflow.Workflow;

public class StaticWorkflowFactory implements WorkflowFactory {
	
	private int currentIndex = 0;
	private final String parentDirectory;
	private final String[] filePaths;
	
	public StaticWorkflowFactory(final String parentDirectory){
		this.parentDirectory = parentDirectory;
		File parentDir = new File(this.parentDirectory);
		filePaths = parentDir.list();
	}

	@Override
	public Workflow createSingleWorkflow() {
		int modBase = filePaths.length;
		int curIndex = (currentIndex++) % modBase;
		String currentFilePath = filePaths[curIndex];
		
		StringBuilder pathBuilder = new StringBuilder(this.parentDirectory);
		if(!this.parentDirectory.endsWith("/")){
			pathBuilder.append("/");
		}
		
		return this.createSingleWorkflow(pathBuilder.append(currentFilePath).toString());
	}

	@Override
	public Workflow createSingleWorkflow(final String filePath) {

		try {
			JAXBContext jaxbContext = JAXBContext.newInstance(ObjectFactory.class);

			Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
			InputStream is = new FileInputStream(filePath);
			Workflow wf = (Workflow) unmarshaller.unmarshal(is);

			return wf;

		} catch (JAXBException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return null;
		}
	}

	@Override
	public List<Workflow> createWorkflows(int numberOfWfs) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Workflow> createWorkflows(String[] filePaths) {
		List<Workflow> wfs = new ArrayList<Workflow>();
		for(String filePath : filePaths){
			Workflow wf = this.createSingleWorkflow(filePath);
			wfs.add(wf);
		}
		return wfs;
	}

	/**
	 * @return the parentDirectory
	 */
	public String getParentDirectory() {
		return parentDirectory;
	}

	/**
	 * @return the currentIndex
	 */
	public int getCurrentIndex() {
		return currentIndex;
	}

	/**
	 * @param currentIndex the currentIndex to set
	 */
	public void setCurrentIndex(int currentIndex) {
		this.currentIndex = currentIndex;
	}

	/**
	 * @return the filePaths
	 */
	public String[] getFilePaths() {
		return filePaths;
	}

}
