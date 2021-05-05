package hello.core.order;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class OrderServiceTest {

    MemberService memberService = new MemberServiceImpl();
    OrderService orderService = new OrderServiceImpl();

    @Test
    void createOrder() {
        //primitive Type -> 기본값이 있기 때문에 null 없음(null 가능성도 있기 때문에)
        //Reference Type -> 빈 객체를 나타내는 null 존재
        long memberId = 1L;
        Member member = new Member(memberId, "memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "itemA", 9000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);    //할인 가격 검증
    }
}
