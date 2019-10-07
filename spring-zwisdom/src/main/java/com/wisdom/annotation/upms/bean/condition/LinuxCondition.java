package com.wisdom.annotation.upms.bean.condition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.env.Environment;
import org.springframework.core.type.AnnotatedTypeMetadata;

/**
 * @author :
 * @create : 2019-05-24 17:46
 * @description :
 */
public class LinuxCondition  implements Condition {
    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        //获取运行环境信息
        Environment environment = context.getEnvironment();

        String property = environment.getProperty("os.name");
        System.out.println("判断，确定设置的 computeruser的对象值");
        if(property.contains("Linux")){
            return true;
        }
        return false;
    }
}
