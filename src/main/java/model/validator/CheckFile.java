package model.validator;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.*;
/**
 * Проверяет существование файла, представленного строкой
 * @see http://docs.jboss.org/hibernate/validator/5.0/reference/en-US/html_single/#validator-customconstraints-simple
 * @see http://habrahabr.ru/post/68318/
 * @author nik
 *
 */
@Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
@Retention(RUNTIME)
@Constraint(validatedBy = CheckFileValidator.class)
public @interface CheckFile {

    String message() default "File not found";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

    @Target({ FIELD, METHOD, PARAMETER, ANNOTATION_TYPE })
    @Retention(RUNTIME)
    @interface List {
        CheckFile[] value();
    }
}