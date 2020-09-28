package job.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;

/**
 * 检验手机号是否合法
 */
public class PhoneValidator implements ConstraintValidator<IsPhone, String> {
    @Override
    public boolean isValid(String s, ConstraintValidatorContext constraintValidatorContext) {
        String reg = "^[1][3,4,5,6,7,8,9][0-9]{9}$";
        Pattern pattern = Pattern.compile(reg);
        boolean matches = pattern.matcher(s).matches();
        return matches;
    }
}
