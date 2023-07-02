package hello.core;

import hello.core.member.Grade;
import hello.core.member.Member;
import hello.core.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {
    public static void main(String[] args) {
//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

//        스프링은 모든 것이 ApplicationContext로 시작, "스프링 컨테이너"라고 함 (모든 Bean들을 관리)*****
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class); // AppConfig 클래스에 있는 환경설정 정보 사용
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "황민현", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println("new member = " + member.getName());
        System.out.println("find Member = " + findMember.getName());
    }
}
