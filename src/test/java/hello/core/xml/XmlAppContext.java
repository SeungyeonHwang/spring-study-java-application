package hello.core.xml;

import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.GenericXmlApplicationContext;

import static org.assertj.core.api.Assertions.*;

public class XmlAppContext {

    //xml 장점 Comfile없이 xml설정과 Config 설정 그대로 바꿔치기 가능 -> 요즘엔 거의 쓰이지 않음
    //xml -> ./resources(Java 코드가 아닌 것은 모두)

    //싱글톤 Bean으로 등록된걸 확인할 수 있음
    @Test
    void xmlAppContext() {
        ApplicationContext ac = new GenericXmlApplicationContext("appConfig.xml");
        MemberService memberService = ac.getBean("memberService", MemberService.class);
        assertThat(memberService).isInstanceOf(MemberService.class);
    }

}
