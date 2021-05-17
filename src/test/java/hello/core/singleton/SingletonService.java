package hello.core.singleton;

//App에 영향 주지 않기 위해서 Test에서 간단히 Singleton 작성
/**
 * 가장 안전한 형태의 Singleton 작성
 * (구현 방법은 여러가지가 있다)
 *
 * 싱글톤 패턴 문제점
 * 싱글톤 패턴을 구현하는 코드 자체가 많이 들어간다.
 * 의존관계상 클라이언트가 구체 클래스에 의존한다. DIP를 위반한다.
 * 클라이언트가 구체 클래스에 의존해서 OCP 원칙을 위반할 가능성이 높다.
 * 테스트하기 어렵다.
 * 내부 속성을 변경하거나 초기화 하기 어렵다.
 * private 생성자로 자식 클래스를 만들기 어렵다.
 * 결론적으로 유연성이 떨어진다.
 * 안티패턴으로 불리기도 한다.
 *
 * -> SpringContainer 에서는 위 단점을 전부 해결 가능
 */
public class SingletonService {

    //자기자신을 private으로 static 선언 -> class Level에 존재 -> 딱 1개만 존재하게 됨
    //static -> 해당객체를 공유하겠다는 의미
    //final -> 재할당 불가, 최초 초기화 이후 다시 초기화를 할 수 없다
    //-> private static final : 메모리에 한번 올라가면 같은 값을 클래스 내부의 전체 필드에서 공유 하게 된다
    private static final SingletonService instance = new SingletonService();

    //객체 인스턴스가 필요하면 이 메서드를 통해서만 조회할 수 있다
    public static SingletonService getInstance() {
        return instance;
    }

    //private 생성자로 선언 못 하게 막아버린다(private 은 자기자신만 호출 할 수 있음)
    private SingletonService() { }

    public void logic() {
        System.out.println("싱글톤 객체 로직 호출");
    }
}
