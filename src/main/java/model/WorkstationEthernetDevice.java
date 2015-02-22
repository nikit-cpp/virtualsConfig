package model;

import javax.validation.constraints.NotNull;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ethernet")
public class WorkstationEthernetDevice {
	@NotNull
	private String name;
	
	@NotNull
	private String vmnet;
	
	public WorkstationEthernetDevice(String name, String vmnet) {
		super();
		this.name = name;
		this.vmnet = vmnet;
	}
	public String getName() {
		return name;
	}
	public String getVmnet() {
		return vmnet;
	}
	
	@Override
	public String toString() {
		return "WorkstationEthernetDevice [name=" + name + ", vmnet=" + vmnet
				+ "]";
	}

}
