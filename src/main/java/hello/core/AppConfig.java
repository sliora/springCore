package hello.core;

import hello.core.discount.FixDiscountPolicy;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import hello.core.member.MemoryMemberRepository;
import hello.core.order.OrderService;
import hello.core.order.OrderServiceImpl;

//객체의 생성과 연결은 AppConfig가 담당
//관심사 분리
public class AppConfig {
    public MemberService memberService() {
        //memoryMemberRepository 객체를 생성하고 그 참조값을 MemberServiceImpl을 생성하면서 생성자로 전달
        //클라이언트인 MemberServiceImpl 입장에서 보면 의존관계를 마치 외부에서 주입하는 것 같다고해서 DI(Dependency Injection) 의존성 주입
        return new MemberServiceImpl(new MemoryMemberRepository()); //생성자 주입
    }

    public OrderService orderService() {
        return new OrderServiceImpl(new MemoryMemberRepository(), new FixDiscountPolicy());
    }
}
