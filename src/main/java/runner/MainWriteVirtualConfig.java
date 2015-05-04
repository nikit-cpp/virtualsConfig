package runner;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import model.Agent;
import model.OS;
import model.User;
import model.VirtualsXml;
import model.VmRunWorkstation;
import model.WorkstationEthernetDevice;
import model.HypervisorConfig;

import com.thoughtworks.xstream.XStream;

public class MainWriteVirtualConfig {
	
	public static final String VIRTUALS_XML = "target/virtuals.xml";

	public static void main(String[] args) throws IOException {
		User u = new User("mylogin", "myPassword");
		Agent a = new Agent("C:\\windows\\system32\\vmAgent.jar", "C:\\windows\\system32\\vmAgent.properties", "C:\\hwTester\\applicationLogsCleaUnit", "C:\\tmp\\logs", "C:\\Program Files\\Java\\bin\\java.exe");
		WorkstationEthernetDevice e = new WorkstationEthernetDevice(1, "vmnet0", "connectionType", "1000");
		List<WorkstationEthernetDevice> eths = new ArrayList<WorkstationEthernetDevice>();
		eths.add(e);
		OS os = OS.WINDOWS;
		VmRunWorkstation w = new VmRunWorkstation("ClearUnit", "C:\\vms\\ClearUnit.vmx", os, 10, a, u, eths);
		
		HypervisorConfig h = new HypervisorConfig("C:\\Program Files\\VMware Vix\\vmrun.exe");
		
		List<VmRunWorkstation> workstations = new ArrayList<VmRunWorkstation>();
		workstations.add(w);
		
		VirtualsXml c = new VirtualsXml(h, workstations);
		
		XStream xstream = new XStream();
		
		Class[] annotated = new Class[] {VmRunWorkstation.class , User.class, WorkstationEthernetDevice.class, VirtualsXml.class};
		xstream.processAnnotations(annotated);
		OutputStream out = new FileOutputStream(VIRTUALS_XML);
		xstream.toXML(c, out);
		
		System.out.println("Writed to " + new File(VIRTUALS_XML).getCanonicalPath());
	}

}
