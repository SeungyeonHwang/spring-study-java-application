package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

import static org.junit.jupiter.api.Assertions.*;

class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        //Bean 조회
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        //ThreadA : A사용자  10000원 주문
        int userAPrice = statefulService1.order("userA", 10000);
        //ThreadB : B사용자  20000원 주문
        int userBPrice = statefulService1.order("userB", 20000);

        //ThreadA : 사용자A 주문 금액 조회
        //공통 Bean, Instance -> 20000 출력
        //int price = statefulService1.getPrice();
        System.out.println("userAPrice = " + userAPrice);

        Assertions.assertThat(userAPrice).isEqualTo(10000);
    }

    static class TestConfig {

        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}