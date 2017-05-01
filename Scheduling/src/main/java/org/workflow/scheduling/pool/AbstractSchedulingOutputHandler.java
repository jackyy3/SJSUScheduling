package org.workflow.scheduling.pool;

import org.workflow.process.Result;
import org.workflow.process.WorkflowProcessor;

/**
 * Abstract class for handling scheduling output.
 */
public abstract class AbstractSchedulingOutputHandler<T> {
    protected final WorkflowProcessor<T> processor;
    
    public AbstractSchedulingOutputHandler(final WorkflowProcessor<T> processor){
    	this.processor = processor;
    }
    
    public abstract Result<T> execute(T t);
    
    public WorkflowProcessor<T> getWorkflowProcessor(){
    	return this.processor;
    }
}
