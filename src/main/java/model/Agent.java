package model;

import org.hibernate.validator.constraints.NotEmpty;

public class Agent {
	@NotEmpty
	private String guestAgentExePath;
	
	@NotEmpty
	private String guestAgentProperties;
	
	@NotEmpty
	private String hostLogsDir;
	
	@NotEmpty
	private String guestLogsDir;
	
	@NotEmpty
	private String guestJavaExe;
	
	public Agent(String guestAgentExePath, String guestAgentProperties, String hostLogsDir,
			String guestLogsDir, String guestJavaExe) {
		super();
		this.guestAgentExePath = guestAgentExePath;
		this.guestAgentProperties = guestAgentProperties;
		this.hostLogsDir = hostLogsDir;
		this.guestLogsDir = guestLogsDir;
		this.guestJavaExe = guestJavaExe;
	}
	public String getGuestAgentExePath() {
		return guestAgentExePath;
	}
	public String getGuestAgentProperties() {
		return guestAgentProperties;
	}
	public String getHostLogsDir() {
		return hostLogsDir;
	}
	public String getGuestLogsDir() {
		return guestLogsDir;
	}
	public String getGuestJavaExe() {
		return guestJavaExe;
	}
	@Override
	public String toString() {
		return "Agent [guestAgentExePath=" + guestAgentExePath
				+ ", guestAgentProperties=" + guestAgentProperties
				+ ", hostLogsDir=" + hostLogsDir + ", guestLogsDir="
				+ guestLogsDir + ", guestJavaExe=" + guestJavaExe + "]";
	}
}
