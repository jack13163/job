package job.imp;

import org.springframework.context.annotation.ImportSelector;
import org.springframework.core.type.AnnotationMetadata;

import java.util.Map;

public class MyImportSelector implements ImportSelector {
    /**
     * 选择一个类
     * @param annotationMetadata
     * @return
     */
    @Override
    public String[] selectImports(AnnotationMetadata annotationMetadata) {
        // 判断是否包含注解
        if(annotationMetadata.hasAnnotation(ServiceSwitch.class.getName())){
            // 获取注解对象
            Map<String, Object> annotationAttributes = annotationMetadata.getAnnotationAttributes(ServiceSwitch.class.getName());
            // 根据注解中配置的value属性动态添加类
            if("redis".equals(annotationAttributes.get("value"))){
                return new String[]{ RedisService.class.getName() };
            }else if("ehcache".equals(annotationAttributes.get("value"))){
                return new String[]{ EhcacheService.class.getName() };
            }
        }
        return new String[0];
    }
}
