package model;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import model.validator.CheckFile;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("workstation")
public class VmRunWorkstation {
	@XStreamAsAttribute
	@NotNull
	private String name;
	
	@XStreamAsAttribute
	@CheckFile
	private String vmxFile;
	
	@Valid
	private Agent agent;
	
	@Valid
	@NotNull(message="User must be present")
	private User user;
	
	@Valid
	@NotNull(message="Забыл инициализировать снапшоты?")
	private Set<Snapshot> snapshots;
	
	@Valid
	private List<WorkstationEthernetDevice> ethernets;
	
	public VmRunWorkstation(String name, String vmxFile, Agent agent, User user,
			List<WorkstationEthernetDevice> ethernets) {
		super();
		this.name = name;
		this.vmxFile = vmxFile;
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
	public Set<Snapshot> getSnapshots() {
		return snapshots;
	}
	public void setSnapshots(Set<Snapshot> snapshots) {
		this.snapshots = snapshots;
	}

	public List<WorkstationEthernetDevice> getEthernets() {
		return ethernets;
	}

	public String getVmxFile() {
		return vmxFile;
	}

	@Override
	public String toString() {
		return "VmRunWorkstation [name=" + name + ", vmxFile=" + vmxFile
				+ ", agent=" + agent + ", user=" + user + ", snapshots="
				+ snapshots + ", ethernets=" + ethernets + "]";
	}

}