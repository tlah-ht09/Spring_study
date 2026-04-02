package hello.core.singleton;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SingletonServiceTest {

    @Test
    @DisplayName("싱글톤 패턴을 적용한 객체 사용")
    public void singletonServiceTest(){
        SingletonService singletonService1 = SingletonService.getInstance();
        SingletonService singletonService2 = SingletonService.getInstance();

        System.out.println("1번 객체 :"+singletonService1);
        System.out.println("2번 객체 :"+singletonService2);

        assertThat(singletonService1).isSameAs(singletonService2);

        singletonService1.logic();
    }

    @Test
    @DisplayName("스프링 컨테이너와 싱글톤")
    void springContainer(){
        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

        //스프링 컨테이너에 등록한 빈 반환
        MemberService memberService1 = ac.getBean(MemberService.class);
        MemberService memberService2 = ac.getBean(MemberService.class);

        System.out.println("1 :"+memberService1);
        System.out.println("1 :"+memberService2);

        Assertions.assertThat(memberService1).isSameAs(memberService2);
    }
}
