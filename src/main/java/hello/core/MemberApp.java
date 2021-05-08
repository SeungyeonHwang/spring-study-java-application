package hello.core;

import hello.core.member.*;

public class MemberApp {

    public static void main(String[] args) {

        //AppConfig에서 결정
        AppConfig appConfig = new AppConfig();
        MemberService memberService = appConfig.memberService();

        Member member = new Member(1L, "memberA", Grade.VIP);
        memberService.join(member);
        Member findMember = memberService.findMember(1L);
        System.out.println("New member = " + member.getName());
        System.out.println("Find Member = " + findMember.getName());
    }
}
