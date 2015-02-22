package virtualsConfig;

import java.util.List;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("virtualConfig")
public class VirtualsConfig {
	private WorkstationHypervisorConfig workstationHypervisor;
	private List<VmRunWorkstation> workstations;
	
	public VirtualsConfig(WorkstationHypervisorConfig workstationHypervisor,
			List<VmRunWorkstation> workstations) {
		super();
		this.workstationHypervisor = workstationHypervisor;
		this.workstations = workstations;
	}

	public WorkstationHypervisorConfig getWorkstationHypervisor() {
		return workstationHypervisor;
	}

	public List<VmRunWorkstation> getWorkstations() {
		return workstations;
	}
	
}
