package virtualsConfig;

import com.thoughtworks.xstream.annotations.XStreamAlias;

@XStreamAlias("ethernet")
public class WorkstationEthernetDevice {
	@Override
	public String toString() {
		return "WorkstationEthernetDevice [name=" + name + ", vmnet=" + vmnet
				+ "]";
	}
	private String name;
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
}
