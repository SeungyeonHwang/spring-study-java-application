package hello.core;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

/**
 * 컴포넌트 스캔 기본 대상
 * 컴포넌트 스캔은 @Component 뿐만 아니라 다음과 내용도 추가로 대상에 포함한다.
 * @Component : 컴포넌트 스캔에서 사용
 * @Controlller : 스프링 MVC 컨트롤러에서 사용
 * @Service : 스프링 비즈니스 로직에서 사용
 * @Repository : 스프링 데이터 접근 계층에서 사용
 * @Configuration : 스프링 설정 정보에서 사용
 */
@Configuration
//자동으로 Spring Bean 뒤져서 등록 시킴(Component), 사실 붙일 필요도 없는게 자동으로 부트에 설정되어 있음
@ComponentScan (
        //Bean등록 제외 시킬 것 지정, Configuration은 이미 수동으로 등록 했기 때문에 제외
        //기존 예제 코드 유지하기 위해서

        //basePackages = "hello.core.member", //-> scan 대상 지정
        //basePackageClasses = AutoAppConfig.class,

        //지정하지 않으면 hello.core 으로 부터 AutoAppConfig 하위 패키지 다뒤진다
        //추천 되는 방법으로는 패키지 위치를 지정하지 않고 설정 정보 클래스를 프로젝트 최상단에 두는 것
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
