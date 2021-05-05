package hello.core.order;

public interface OrderService {
    //주문 생성 -> 주문 내역 return
    Order createOrder(Long memberId, String itemName, int itemPrice);
}
