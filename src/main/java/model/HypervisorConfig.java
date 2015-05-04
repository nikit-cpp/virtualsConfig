package model;

import model.validator.CheckFile;

import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

public class HypervisorConfig {
	@Override
	public String toString() {
		return "WorkstationHypervisorConfig [vmRunExe=" + vmRunExe + "]";
	}

	public HypervisorConfig(String vmRunExe) {
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
