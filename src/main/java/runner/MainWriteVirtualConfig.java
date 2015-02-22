package runner;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ValidationException;
import javax.validation.Validator;

import virtualsConfig.Agent;
import virtualsConfig.User;
import virtualsConfig.VirtualsConfig;
import virtualsConfig.VmRunWorkstation;
import virtualsConfig.WorkstationEthernetDevice;
import virtualsConfig.WorkstationHypervisorConfig;

import com.thoughtworks.xstream.XStream;

public class MainWriteVirtualConfig {

	public static void main(String[] args) throws FileNotFoundException {
		User u = new User("mylogin", "myPassword");
		Agent a = new Agent("C:\\windows\\system32\\vmAgent.jar", "C:\\windows\\system32\\vmAgent.properties", "C:\\hwTester\\applicationLogsCleaUnit", "C:\\tmp\\logs", "C:\\Program Files\\Java\\bin\\java.exe");
		WorkstationEthernetDevice e = new WorkstationEthernetDevice("1000", "vmnet0");
		List<WorkstationEthernetDevice> eths = new ArrayList<WorkstationEthernetDevice>();
		eths.add(e);
		VmRunWorkstation w = new VmRunWorkstation("ClearUnit", a, u, eths);
		
		WorkstationHypervisorConfig h = new WorkstationHypervisorConfig("C:\\Program Files\\VMware Vix\\vmrun.exe");
		
		List<VmRunWorkstation> workstations = new ArrayList<VmRunWorkstation>();
		workstations.add(w);
		
		VirtualsConfig c = new VirtualsConfig(h, workstations);
		
		XStream xstream = new XStream();
		
		Class[] annotated = new Class[] {VmRunWorkstation.class , User.class, WorkstationEthernetDevice.class, VirtualsConfig.class};
		xstream.processAnnotations(annotated);
		OutputStream os = new FileOutputStream("target/virtuals.xml");
		xstream.toXML(c, os);
	}

}
