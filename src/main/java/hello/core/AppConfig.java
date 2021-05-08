package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.*;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//애플리케이션 전체를 구성, 설정
//객체의 생성과 연결 담당
//실제 동작에 필요한 구현객체를 실행함
//설계에 대한 정보가 고스란히 여기서 보여진다(전체 구성 빠르게 파악 가능)
public class AppConfig {

    public MemberService memberService() {
        return new MemberServiceImpl(memberRepository());
    }

    //중복제거, 1.Service역할, 2.Repository 역할 나누는 Refactoring
    //뭘 들어가는지, 알기 쉽고, 코드 한줄만 바꾸면 끝나게 된다.
    private MemberRepository memberRepository() {
        return new MemberMemoryRepository();
    }

    public OrderService orderService() {
        return new OrderServiceImpl(memberRepository(), discountPolicy());
    }

    //이것도 new 하지말고 메소드화 시키는 Refactoring
    //OCP 준수(확장에는 열려있고 변경에는 닫혀있다.)
    public DiscountPolicy discountPolicy() {
//        return new FixDiscountPolicy();
        return new RateDiscountPolicy();
    }
}
