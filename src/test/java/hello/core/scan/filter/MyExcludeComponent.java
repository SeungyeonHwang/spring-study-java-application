package hello.core.scan.filter;

import java.lang.annotation.*;

@Target(ElementType.TYPE)   //class level
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyExcludeComponent {  //이 어노테이션이 붙은 것은 Component Scan에 제외 거라는 의미
}
