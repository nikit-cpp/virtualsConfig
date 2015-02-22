package virtualsConfig;

import java.io.File;
import java.util.List;

import javax.validation.constraints.NotNull;

import virtualsConfig.validator.CheckFile;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("workstation")
public class VmRunWorkstation {
	@Override
	public String toString() {
		return "VmRunWorkstation [name=" + name + ", agent=" + agent
				+ ", user=" + user + ", snapshots=" + snapshots
				+ ", ethernets=" + ethernets + "]";
	}

	@XStreamAsAttribute
	private String name;
	@XStreamAsAttribute
	@CheckFile("lulz stub")
	private String vmxFile;
	private Agent agent;
	private User user;
	@NotNull(message="Нет снапшотов")
	private List<Snapshot> snapshots;
	private List<WorkstationEthernetDevice> ethernets;
	
	public VmRunWorkstation(String name, Agent agent, User user,
			List<WorkstationEthernetDevice> ethernets) {
		super();
		this.name = name;
		this.agent = agent;
		this.user = user;
		this.ethernets = ethernets;
	}
	
	public String getName() {
		return name;
	}
	public Agent getAgent() {
		return agent;
	}
	public User getUser() {
		return user;
	}
	public List<Snapshot> getSnapshots() {
		return snapshots;
	}
	public void setSnapshots(List<Snapshot> snapshots) {
		this.snapshots = snapshots;
	}

	public List<WorkstationEthernetDevice> getEthernets() {
		return ethernets;
	}

	public String getVmxFile() {
		return vmxFile;
	}

	public void setVmxFile(String vmxFile) {
		this.vmxFile = vmxFile;
	}
}
