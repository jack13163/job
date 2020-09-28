package job.norepeat;


import java.lang.annotation.*;

/**
 * 防止表单的重复提交
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface NoRepeatSubmit {
}
