package job.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.METHOD, ElementType.FIELD, ElementType.ANNOTATION_TYPE, ElementType.CONSTRUCTOR, ElementType.PARAMETER, ElementType.TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(
        validatedBy = {PhoneValidator.class}
)
public @interface IsPhone {
    String message() default "手机号码不合法";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
