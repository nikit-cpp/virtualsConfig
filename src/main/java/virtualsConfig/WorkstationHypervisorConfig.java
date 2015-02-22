package virtualsConfig;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class WorkstationHypervisorConfig {
	public WorkstationHypervisorConfig(String vmRunExe) {
		super();
		this.vmRunExe = vmRunExe;
	}
	
	@XStreamAsAttribute
	private String vmRunExe;

	public String getVmRunExe() {
		return vmRunExe;
	}
}
