package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberMemoryRepository;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//애플리케이션 전체를 구성, 설정
//객체의 생성과 연결 담당
//실제 동작에 필요한 구현객체를 실행함
//설계에 대한 정보가 고스란히 여기서 보여진다(전체 구성 빠르게 파악 가능)
@Configuration
public class AppConfig {

    /**
     * [ Call History ]
     * call AppConfig.memberService
     * call AppConfig.memberRepository -> 3번호출 되어야 되는데 1번만 호출? 
     * call AppConfig.orderService
     */

    //@Bean memberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()

    //-> Spring Container 등록 됨
    @Bean
    public MemberService memberService() {
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository());
    }

    //중복제거, 1.Service역할, 2.Repository 역할 나누는 Refactoring
    //뭘 들어가는지, 알기 쉽고, 코드 한줄만 바꾸면 끝나게 된다.
    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemberMemoryRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //이것도 new 하지말고 메소드화 시키는 Refactoring
    //OCP 준수(확장에는 열려있고 변경에는 닫혀있다.)
    @Bean
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
