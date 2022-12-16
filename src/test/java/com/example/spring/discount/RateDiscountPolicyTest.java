package com.example.spring.discount;

import com.example.spring.member.Grade;
import com.example.spring.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RateDiscountPolicyTest {
    RateDiscountPolicy discountPolicy = new RateDiscountPolicy();

    @Test
    @DisplayName("VIP 는 10 % 할인이 적용되어야 한다")
    void vip_o(){
        Member member = new Member(1L,"memberVIP", Grade.VIP);
        int discount = discountPolicy.discount(member,10000);
        Assertions.assertThat(discount).isEqualTo(1000);
    }

    @Test
    @DisplayName("VIP 가 아니면 할인 적용 안됨..")
    void vip_x(){
        Member member = new Member(1L,"memberVIP", Grade.BASIC);
        int discount = discountPolicy.discount(member,10000);
        Assertions.assertThat(discount).isEqualTo(0);
    }

}