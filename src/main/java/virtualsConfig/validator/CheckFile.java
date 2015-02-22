package virtualsConfig.validator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;

@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckFileValidator.class)
public @interface CheckFile {

    String message() default "Файл не найден";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    String value();

    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @interface List {
        CheckFile[] value();
    }
}