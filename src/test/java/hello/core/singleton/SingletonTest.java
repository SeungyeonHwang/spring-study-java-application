package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * 순수한 DI 컨테이너 문제점 :
 * 보통의 AppService는 동시다발적으로 요청이 이루어지는데,
 * 3명의 고객이 각각 다른 요청을 할경우 그때마다 인스턴스를 생성한다 -> Memory 낭비
 * 해결책 -> 해당객체 1개 생성, 공유하도록 처리
 * (Singleton : 클래스의 인스턴스가 딱 1개만 생성되는 것을 보장하는 디자인 패턴)
 */
public class SingletonTest {

    @Test
    @DisplayName("Spring 없는 순수한 DI 컨테이너")
    void pureContainer() {

        AppConfig appConfig = new AppConfig();
        //1. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService1 = appConfig.memberService();

        //2. 조회 : 호출할 때 마다 객체를 생성
        MemberService memberService2 = appConfig.memberService();

        //참조값이 다른 것을 확인 -> JVM 메모리에 계속 생성되서 올라감
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //memberService1 != memberService2
        //객체가 총 4개가 생성됨
        assertThat(memberService1).isNotSameAs(memberService2);
    }

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    void singletonServiceTest() {
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        //memberService1 == memberService2
        System.out.println("singletonService1 = " + singletonService1);
        System.out.println("singletonService2 = " + singletonService2);

        //equal 값 비교
        //same == 인스턴스까지 같은지 비교
        assertThat(singletonService1).isSameAs(singletonService2);
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer() {

        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //SpringContainer 에서 꺼내서 사용
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        //참조값이 다른 것을 확인 -> JVM 메모리에 계속 생성되서 올라감
        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        //조회 할 때마다, 같은 객체 반환(공유하고 있음)
        //memberService1 == memberService2
        assertThat(memberService1).isSameAs(memberService2);

    }
}
