package hello.core.singleton;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;

public class StatefulServiceTest {

    @Test
    void statefulServiceSingleton() {
        ApplicationContext ac = new AnnotationConfigApplicationContext(TestConfig.class);
        StatefulService statefulService1 = ac.getBean(StatefulService.class);
        int a = statefulService1.order("userA", 10000);
        StatefulService statefulService2 = ac.getBean(StatefulService.class);
        int b = statefulService2.order("userB", 20000);

        Assertions.assertThat(a).isEqualTo(10000);
    }

    static class TestConfig {
        @Bean
        public StatefulService statefulService() {
            return new StatefulService();
        }
    }
}
