package model;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.NotEmpty;

import model.validator.CheckFile;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;

@XStreamAlias("workstation")
public class VmRunWorkstation {
	@XStreamAsAttribute
	@NotEmpty
	private String name;
	
	@Min(0)
	@XStreamAsAttribute
	private int sleepBeforeDesktopPresent;
	
	@XStreamAsAttribute
	@NotNull
	private OS os;
	
	@XStreamAsAttribute
	@CheckFile
	private String vmxPath;
	
	// Приказываем провалидировать Agent, если он не null
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
	
	public VmRunWorkstation(String name, String vmxPath, OS os, int sleepBeforeDesktopPresent, Agent agent, User user,
			List<WorkstationEthernetDevice> ethernets) {
		super();
		this.name = name;
		this.vmxPath = vmxPath;
		this.os = os;
		this.sleepBeforeDesktopPresent = sleepBeforeDesktopPresent;
		this.agent = agent;
		this.user = user;
		this.ethernets = ethernets;
	}
	
	public String getName() {
		return name;
	}
	
	public int getSleepBeforeDesktopPresent() {
		return sleepBeforeDesktopPresent;
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

	public String getVmxPath() {
		return vmxPath;
	}

	@Override
	public String toString() {
		return "VmRunWorkstation [name=" + name + ", vmxPath=" + vmxPath
				+ ", agent=" + agent + ", user=" + user + ", snapshots="
				+ snapshots + ", ethernets=" + ethernets + "]";
	}

    public OS getOs() {
        return os;
    }

}
