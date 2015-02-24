package model;

import java.util.List;
import javax.validation.Valid;
import com.thoughtworks.xstream.annotations.XStreamAlias;

// Алиас приказывает XStream (де)сериализовывать <virtualConfig> вместо <com.website.packagename.VirtualsConfig>
@XStreamAlias("virtualConfig")
public class VirtualsXml {
	// Приказываем хибернейт валидатору провести валидацию непримитивного типа WorkstationHypervisorConfig
	// такой аннотацией можно помечать непримитивные типы, их коллекции или массивы
	// Валидация производится, если поле не null
	@Valid
	private HypervisorConfig workstationHypervisor;
	
	@Valid
	private List<VmRunWorkstation> workstations;
	
	public VirtualsXml(HypervisorConfig workstationHypervisor,
			List<VmRunWorkstation> workstations) {
		super();
		this.workstationHypervisor = workstationHypervisor;
		this.workstations = workstations;
	}

	public HypervisorConfig getWorkstationHypervisor() {
		return workstationHypervisor;
	}

	public List<VmRunWorkstation> getWorkstations() {
		return workstations;
	}
	
	@Override
	public String toString() {
		return "VirtualsConfig [workstationHypervisor=" + workstationHypervisor
				+ ", workstations=" + workstations + "]";
	}
}
