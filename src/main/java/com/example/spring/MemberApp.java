package com.example.spring;

import com.example.spring.member.Grade;
import com.example.spring.member.Member;
import com.example.spring.member.MemberService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MemberApp {

    public static void main(String[] args) {

        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService = applicationContext.getBean("memberService",MemberService.class);
        Member member = new Member(1L,"memberA", Grade.VIP);
        memberService.join(member);

        Member findMember = memberService.findMember(1L);
        System.out.println(findMember.getName());
        System.out.println(member.getName());
    }

}
