package hello.core.beanfind;

import hello.core.AppConfig;
import hello.core.member.MemberService;
import hello.core.member.MemberServiceImpl;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.NoSuchBeanDefinitionException;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class ApplicationContextBasicFindTest {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("이름으로 빈 조회")
    void finBeanByName(){
        MemberService memberService = ac.getBean("memberService", MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);

    }

    @Test
    @DisplayName("타입으로만 빈 조회")
    void finBeanByType(){
        MemberService memberService = ac.getBean( MemberService.class);

        assertThat(memberService).isInstanceOf(MemberService.class);

    }

    @Test
    @DisplayName("이름으로 빈 조회")
    void finBeanByName2(){
        MemberService memberService = ac.getBean("memberService", MemberServiceImpl.class);

        assertThat(memberService).isInstanceOf(MemberServiceImpl.class);

    }

    @Test
    @DisplayName("이름으로 빈 조회X")
    void finBeanByNameX(){
        //MemberService memberService = ac.getBean("neekoggorijjim", MemberService.class);

        assertThrows(NoSuchBeanDefinitionException.class,()-> ac.getBean("neekoggorijjim", MemberService.class));

    }
}
