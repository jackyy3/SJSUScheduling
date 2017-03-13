package org.workflowsim.scheduling;

import java.util.Iterator;
import java.util.List;

import org.workflow.Cloudlet;
import org.workflow.Task;
import org.workflowsim.CondorVM;
import org.workflowsim.WorkflowSimTags;

public class MaxChildSchedulingAlgorithm  extends BaseSchedulingAlgorithm {

	@Override
	public void run() throws Exception {
		
		List<Task> tasks = getCloudletList();
		
		for(Task task : tasks) {
			task.setIsChecked(false);
		}
		
		for(int i = 0; i < tasks.size(); i++) {
			int maxIndex = 0;
			Task maxCloudlet = null;
			for(int j = 0; j < tasks.size(); j++) {
				if(!tasks.get(j).getIsChecked()) {
					maxCloudlet = tasks.get(j);
					maxIndex = j;
					break;
				}
			}
			
			if(maxCloudlet == null) {
				break;
			}
			
			for(int j = 0; j < tasks.size(); j++) {
				if(tasks.get(j).getIsChecked()) {
					continue;
				}
				
				if(tasks.get(j).getChildList().size() > maxCloudlet.getChildList().size()) {
					maxCloudlet = tasks.get(j);
				}
			}
			
			maxCloudlet.setIsChecked(true);
			CondorVM first_IDLE_VM = null;
            for (Iterator itc = getVmList().iterator(); itc.hasNext();) {
                CondorVM vm = (CondorVM) itc.next();
                if (vm.getState() == WorkflowSimTags.VM_STATUS_IDLE) {
                    vm.setState(WorkflowSimTags.VM_STATUS_BUSY);
                    maxCloudlet.setVmId(vm.getId());
                    first_IDLE_VM = vm;
                    getScheduledList().add(maxCloudlet);
                    break;
                }
            }
            //no vm available 
            if (first_IDLE_VM == null) {
                break;
            }
		}
	}

}
