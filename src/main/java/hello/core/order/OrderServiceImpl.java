package hello.core.order;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberMemoryRepository;
import hello.core.member.MemberRepository;

public class OrderServiceImpl implements OrderService{

    //회원 저장소의 구현체까지 의존(추상 / 구현)
    //DIP, OCP 위반 -> 스프링 컨테이너의 탄생이유와 관련
    private final MemberRepository memberRepository = new MemberMemoryRepository();
    //OrderService 입장에서는 DiscountPolicy에 대해 모른다 -> 좋은 설계
    //바꿔치기 가능 But 할인 정책을 바꿀려면 클라이언트인 "OrderServiceImpl"을 수정해야 함(OCP 위반), 추상과 구체를 같이 의존(DIP 위반) -> NG
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    //private final DiscountPolicy discountPolicy = new RateDiscountPolicy();
    //(수정 후)
    private DiscountPolicy discountPolicy;

    @Override
    public Order createOrder(Long memberId, String itemName, int itemPrice) {
        Member member = memberRepository.findById(memberId);    //회원을 찾는다 -> 던진다(Grade를 넘겨도 될지는 상황에 따라 다름)
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(memberId, itemName, itemPrice, discountPrice);
    }
}
