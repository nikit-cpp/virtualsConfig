package virtualsConfig.validator;

import java.io.File;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class CheckFileValidator implements ConstraintValidator<CheckFile, String> {

    @Override
    public void initialize(CheckFile constraintAnnotation) { }

    @Override
    public boolean isValid(String object, ConstraintValidatorContext constraintContext) {
        if ( object == null ) {
            return false;
        }
        
        if(!new File(object).exists()){
        	return false;
        }
        
        return true;
    }
}