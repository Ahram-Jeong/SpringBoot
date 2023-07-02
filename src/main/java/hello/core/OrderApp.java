package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import hello.core.order.Order;
import hello.core.order.OrderService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class OrderApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();
//        OrderService orderService = appConfig.orderService();

//        스프링은 모든 것이 ApplicationContext로 시작, "스프링 컨테이너"라고 함 (모든 Bean들을 관리)*****
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // AppConfig 클래스에 있는 환경설정 정보 사용
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);
        OrderService orderService = applicationContext.getBean("orderService", OrderService.class);

        Long memberId = 1L;
        Member member = new Member(memberId, "황민현", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId, "iPad", 20000);
        System.out.println("oder = " + order);
        System.out.println("oder.calculatePrice() = " + order.calculatePrice());

    }
}
