package hello.core;

import hello.core.discount.DiscountPolicy;
import hello.core.discount.FixDiscountPolicy;
import hello.core.discount.RateDiscountPolicy;
import hello.core.member.MemberRepository;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//객체의 생성과 연결은 AppConfig가 담당
//관심사 분리
@Configuration
public class AppConfig {

    //@Bean MemberService -> new MemoryMemberRepository()
    //@Bean orderService -> new MemoryMemberRepository()

    @Bean
    public MemberService memberService() {
        //memoryMemberRepository 객체를 생성하고 그 참조값을 MemberServiceImpl을 생성하면서 생성자로 전달
        //클라이언트인 MemberServiceImpl 입장에서 보면 의존관계를 마치 외부에서 주입하는 것 같다고해서 DI(Dependency Injection) 의존성 주입
        //return new MemberServiceImpl(new MemoryMemberRepository()); //생성자 주입
        System.out.println("call AppConfig.memberService");
        return new MemberServiceImpl(memberRepository()); //option + cmmand + m 을 눌러서 메소드를 추출함
    }

    @Bean
    public MemberRepository memberRepository() {
        System.out.println("call AppConfig.memberRepository");
        return new MemoryMemberRepository();
    }

    @Bean
    public OrderService orderService() {
        System.out.println("call AppConfig.orderService");
        return new OrderServiceImpl(memberRepository(),discountPolicy());
    }

    @Bean
    public DiscountPolicy discountPolicy() {
        return new RateDiscountPolicy();
    }
}
