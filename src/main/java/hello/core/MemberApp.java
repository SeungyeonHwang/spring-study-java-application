package hello.core;

import hello.core.member.*;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

//        AppConfig appConfig = new AppConfig();
//        MemberService memberService = appConfig.memberService();

        //Spring Container Version
        //AppConfig 환경설정 정보 가지고 @Bean SpringBean에 집어넣어서 관리 해줌
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        //찾을 객체 선택, Type
        MemberService memberService = applicationContext.getBean("memberService", MemberService.class);

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("New member = " + member.getName());
        System.out.println("Find Member = " + findMember.getName());
    }
}
