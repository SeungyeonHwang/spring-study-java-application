package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)   //class level
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyIncludeComponent {  //이 어노테이션이 붙은 것은 Component Scan에 추가할 거라는 의미
}
