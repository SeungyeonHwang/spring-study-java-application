package hello.core.member;

//BusinessLogic -> 용어 조차도 일반 사람도 이해할 수 있는 비즈니스 용어 사용
public interface MemberService {

    void join(Member member);

    Member findMember(Long memberId);

}
