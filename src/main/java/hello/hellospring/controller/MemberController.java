package hello.hellospring.controller;

import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MemberController {
    private final MemberService memberService;
    //@Autowired private MemberService memberService //이런 식은 필드 주입

    //Setter 주입
    /*@Autowired
    public MemberService setMemberService(MemberService memberService) {
        this.memberService = memberService;
    }*/

    @Autowired //컨테이너에 있는 memberService를 연결시켜줌
    //이런 식으로 생성자를 통해 MemberService를 넣어주는 걸 생성자 주입이라고 함
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }
}
