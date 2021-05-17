package hello.core.singleton;

/**
 * 무상태(stateless)로 설계해야 한다!
 * 특정 클라이언트에 의존적인 필드가 있으면 안된다.
 * 특정 클라이언트가 값을 변경할 수 있는 필드가 있으면 안된다!
 * 가급적 읽기만 가능해야 한다.
 * 필드 대신에 자바에서 공유되지 않는, 지역변수, 파라미터, ThreadLocal 등을 사용해야 한다.
 * 스프링 빈의 필드에 공유 값을 설정하면 정말 큰 장애가 발생할 수 있다!!!
 * 값을 공유함으로써 큰 문제가 생김 -> 지역변수로 처리 할 것
 */
public class StatefulService {

    private int price;  //상태를 유지하는 필드 -> 공유값을 쓰는 것은 바람직하지 않음

    public int order(String name, int price) {
        System.out.println("name = " + name + " || price = " + price);
        //this.price = price; //문제의 지점
        return price;
    }

    public void getPrice() {
        //return price;
    }
}
