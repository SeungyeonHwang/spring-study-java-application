package hello.core.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class MemberServiceTest {

    MemberService memberService = new MemberServiceImpl();

    //Unit 테스트가 중요한이유 : 테스트할때 속도가 빠르기 때문에 순수 자바코드로 테스트 하는 것도 중요 하다
    //Unit Test : 스프링, 컨테이너 등의 도움 없이 순수하게 자바로 이루어진 Test
    @Test
    void join() {
        //given
        Member member = new Member(1L, "memberA", Grade.VIP);

        //when
        memberService.join(member);
        Member findMember = memberService.findMember(1L);

        //then
        Assertions.assertThat(member).isEqualTo(findMember);
    }
}
