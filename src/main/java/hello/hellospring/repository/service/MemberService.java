package hello.hellospring.repository.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;

import java.util.List;
import java.util.Optional;

//컨트롤 + 쉬프트 + T로 테스트 클래스 생성 가능
public class MemberService {

    private final MemberRepository memberRepository;

    //의존성주입(DI : Dependency Injection)
    //직접 리포지토리를 생성하는 것이 아니라 외부에서 받아옴.
    public MemberService(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }


    //회원가입
    public Long join(Member member) {
        //같은 이름의 중복 회원X
        validateDuplicateMember(member);//중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    //컨트롤 + 알트 + m으로 메서드 뽑을 수 있음
    private void validateDuplicateMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(m -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    //전체 회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
