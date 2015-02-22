package virtualsConfig;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.ValidationException;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;

import com.thoughtworks.xstream.XStream;

public class MainReadVirtualConfig {

	public static void main(String[] args) throws FileNotFoundException {		
		XStream xstream = new XStream();
		
		Class[] annotated = new Class[] {VmRunWorkstation.class , User.class, WorkstationEthernetDevice.class, VirtualsConfig.class};
		xstream.processAnnotations(annotated);
		InputStream is = new FileInputStream("target/virtuals.xml");
		VirtualsConfig c = (VirtualsConfig) xstream.fromXML(is);
        
		System.out.println(c);
        Validator validator = Validation.buildDefaultValidatorFactory().getValidator();
		validate(c, validator);		
	}
	
	
    public static void validate(Object object, Validator validator) throws ValidationException {
        Set<ConstraintViolation<Object>> constraintViolations = validator
                .validate(object);
        if(constraintViolations.size()!=0){
            System.err.println("[Hibernate Validator] Validation erors:");
            for (ConstraintViolation<Object> cv : constraintViolations)
                System.err.println(String.format(
                        "property: [%s], value: [%s], message: [%s]",
                        cv.getPropertyPath(), cv.getInvalidValue(), cv.getMessage()));

            throw new ValidationException();
        }
    }


}
