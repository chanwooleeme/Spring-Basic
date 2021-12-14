package hello.core.member;

import hello.core.AppConfig;
import org.junit.jupiter.api.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class MemberServiceTest {

    MemberService memberService;

    @BeforeEach
    public void beforeEach() {
        AppConfig appconfig = new AppConfig();
        memberService = appconfig.memberService();
    }

    @Test
    void join() {
        Member member = new Member(1L, "Lee", Grade.BASIC);
        memberService.join(member);
        assertThat(member).isEqualTo(memberService.findMember(1L));
    }
}