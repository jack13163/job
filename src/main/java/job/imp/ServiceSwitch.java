package job.imp;

import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Import(MyImportSelector.class)// 引入类
public @interface ServiceSwitch {
    // 开关标志
    String value() default "redis";
}
