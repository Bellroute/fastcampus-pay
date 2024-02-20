package common;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;
import org.springframework.stereotype.Component;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Component
public @interface WebAdapter { // 핵사고날 아키텍쳐에서 Controller를 카리키는 주석 용도로 사용되는 어노테이션

    @AliasFor(annotation = Component.class)
    String value() default "";
}