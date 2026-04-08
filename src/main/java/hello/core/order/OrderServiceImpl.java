package hello.core.order;

import hello.core.annotation.MainDiscountPolicy;
import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.Member;
import hello.core.member.MemberRepository;
import hello.core.member.MemoryMemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
//@RequiredArgsConstructor //거의 이거 씀
public class OrderServiceImpl implements OrderService {

    private final MemberRepository memberRepository ;
    //private final DiscountPolicy discountPolicy = new FixDiscountPolicy();
    private final  DiscountPolicy discountPolicy;

    //RequiredArgsConstructor가 자동으로 생성자 만들어줌
    public OrderServiceImpl(MemberRepository memberRepository, @MainDiscountPolicy DiscountPolicy discountPolicy) {
        this.memberRepository = memberRepository;
        this.discountPolicy = discountPolicy;
    }



    @Override
    public Order createOrder(Long id, String itemName, int itemPrice) {
        Member member = memberRepository.findById(id);
        int discountPrice = discountPolicy.discount(member, itemPrice);

        return new Order(id, itemName,itemPrice, discountPrice);
    }

    //test dragon
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
