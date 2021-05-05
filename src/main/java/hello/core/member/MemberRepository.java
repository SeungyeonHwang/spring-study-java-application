package hello.core.member;

//역할-구현에서 역할(둘은 보통은 다른 패키지에 넣음)
//DB와의 접근 등의 역할
public interface MemberRepository {

    //회원을 저장
    void save(Member member);

    //회원 한명을 조회
    Member findById(Long memberId);
}
