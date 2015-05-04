package model.validator;

import java.io.File;
import java.io.IOException;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckFileValidator implements ConstraintValidator<CheckFile, String> {

    @Override
    public void initialize(CheckFile constraintAnnotation) { }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
    	boolean isValid = true;
    	
        String canonicalPath = object;

        if ( object == null ) {
        	isValid = false;
        }else{
	        File probe = new File(object);
			try {
				canonicalPath = probe.getCanonicalPath();
			} catch (IOException e) {
			}
	        if(!probe.exists()){
	        	isValid = false;
	        }
	        if(!probe.isFile()){
                isValid = false;
            }
        }
        
        if ( !isValid ) {
            constraintContext.disableDefaultConstraintViolation();
            constraintContext.buildConstraintViolationWithTemplate("File '"+canonicalPath + "' not found or this is directory")
            .addConstraintViolation();
        }
        
        return isValid;
    }
}