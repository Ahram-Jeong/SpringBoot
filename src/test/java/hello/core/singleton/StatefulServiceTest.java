package hello.core.singleton;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

class StatefulServiceTest {
    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);

        // ThreadA : 황민현이 100000원 주문
        int userAPrice = statefulService1.order("황민현", 100000);
        // ThreadB : 이준혁이 200000원 주문
        int userBPrice = statefulService2.order("이준혁", 200000);

        // ThreadA : 황민현이 주문 금액 조회
//        int price = stateFulService1.getPrice();
        System.out.println("price = " + userAPrice);

//        Assertions.assertThat(stateFulService1.getPrice()).isEqualTo(200000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}