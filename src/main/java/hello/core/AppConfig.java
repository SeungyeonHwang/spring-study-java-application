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

/**
 * @Configuration 안붙이고 @Bean 만적용한다면
 * 순수한 Class 나온다 (싱글톤 위한 조작이 없어짐 -> 싱글톤 보장 못함)
 * 크게 고민할 것이 없다, 스프링 설정정보는 항상 @Configuration 사용
 */

public class AppConfig {

    /**
     * [ Call History ]
     * call AppConfig.memberService
     * call AppConfig.memberRepository -> 3번호출 되어야 되는데 1번만 호출?
     * call AppConfig.orderService
     */

    //@Autowired MemberRepository memberRepository; -> Bean에 등록된걸 가져와서 다시 쓰는 것 (이런 방법도 가능)

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
