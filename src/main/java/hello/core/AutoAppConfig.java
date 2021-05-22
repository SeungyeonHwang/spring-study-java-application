package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
//자동으로 Spring Bean 뒤져서 등록 시킴
@ComponentScan (
        //Bean등록 제외 시킬 것 지정, Configuration은 이미 수동으로 등록 했기 때문에 제외
        //기존 예제 코드 유지하기 위해서
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
