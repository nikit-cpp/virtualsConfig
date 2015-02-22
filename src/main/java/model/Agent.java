package model;

import javax.validation.constraints.NotNull;

public class Agent {
	@NotNull
	private String guestAgentExePath;
	
	@NotNull
	private String guestAgentProperties;
	
	@NotNull
	private String hostLogsDir;
	
	@NotNull
	private String guestLogsDir;
	
	@NotNull
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
