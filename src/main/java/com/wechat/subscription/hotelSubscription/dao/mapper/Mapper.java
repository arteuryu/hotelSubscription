package com.wechat.subscription.hotelSubscription.dao.mapper;
import org.springframework.stereotype.Component;
import java.lang.annotation.*;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Documented
@Component
public @interface Mapper {
    String value() default "";
}
