package model;

import model.validator.CheckFile;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class WorkstationHypervisorConfig {
	@Override
	public String toString() {
		return "WorkstationHypervisorConfig [vmRunExe=" + vmRunExe + "]";
	}

	public WorkstationHypervisorConfig(String vmRunExe) {
		super();
		this.vmRunExe = vmRunExe;
	}
	
	@XStreamAsAttribute
	@CheckFile
	private String vmRunExe;

	public String getVmRunExe() {
		return vmRunExe;
	}
}
