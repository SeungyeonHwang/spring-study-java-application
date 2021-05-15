package hello.core.beanfind;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoUniqueBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextExtendsFindTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);

    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상있으면, 중복 오류가 발생")
    void findByParentTypeDuplicate() {
        //No Unique Exception
        assertThrows(NoUniqueBeanDefinitionException.class,
                () -> ac.getBean(DiscountPolicy.class));

    }


    @Test
    @DisplayName("부모 타입으로 조회 시, 자식이 둘 이상있으면, 빈 이름을 지정하면 된다")
    void findByParentTypeBeanName() {
        DiscountPolicy rateDiscountPolicy = ac.getBean("rateDiscountPolicy", DiscountPolicy.class);
        assertThat(rateDiscountPolicy).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("특정 하위 타입으로 조회(그다지 좋은 방법은 아님)")
    void findBeanBySubType() {
        RateDiscountPolicy bean = ac.getBean(RateDiscountPolicy.class);
        assertThat(bean).isInstanceOf(RateDiscountPolicy.class);
    }

    @Test
    @DisplayName("부모 타입으로 모두 조회하기")
    void findAllBeanByParentType() {
        Map<String, DiscountPolicy> beansOfType = ac.getBeansOfType(DiscountPolicy.class);
        assertThat(beansOfType.size()).isEqualTo(2);
        //실제 테스트 케이스 짤때는 출력물 만들면 안된다 -> pass / fail을 시스템이 결정하게 해야된다(눈으로 보고 판단 하는게 아님)
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " || value" + beansOfType.get(key));
        }
    }

    //Spring 내부 Bean 까지 다 튀어 나옴
    @Test
    @DisplayName("부모 타입으로 모두 조회하기 - Object")
    void findAllBeanByObjectType() {
        Map<String, Object> beansOfType = ac.getBeansOfType(Object.class);
        for (String key : beansOfType.keySet()) {
            System.out.println("key = " + key + " || value" + beansOfType.get(key));
        }
    }

    //DiscountPolicy 타입으로 조회하면 자식 타입이 2개 나와야 된다
    @Configuration
    static class TestConfig {

        //쪼개서 등록하는 것은 역할과 구현을 분리하는 것과 같은 맥락 -> DiscountPolicy를 보고 뭐에 관련된 건지 파악 가능
        @Bean
        public DiscountPolicy rateDiscountPolicy() {
            return new RateDiscountPolicy();
        }

        @Bean
        public DiscountPolicy fixDiscountPolicy() {
            return new FixDiscountPolicy();
        }
    }

}
