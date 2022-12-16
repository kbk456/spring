package com.example.spring;

import com.example.spring.member.Grade;
import com.example.spring.member.Member;
import com.example.spring.member.MemberService;
import com.example.spring.order.Order;
import com.example.spring.order.OrderService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class OrderAppTest {
    MemberService memberService;
    OrderService orderService;

    @BeforeEach
    public void setMemberService(){
        AppConfig appConfig = new AppConfig();
        memberService = appConfig.memberService();
        orderService = appConfig.orderService();
    }

    @Test
    void createOrder(){
        long memberId = 1L;
        Member member = new Member(memberId,"memberA", Grade.VIP);
        memberService.join(member);

        Order order = orderService.createOrder(memberId,"itemA",10000);
        Assertions.assertThat(order.getDiscountPrice()).isEqualTo(1000);
    }

}