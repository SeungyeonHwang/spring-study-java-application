package hello.core.member;

//구현체 하나의 경우에는 MemberServiceImpl 관례상 사용
public class MemberServiceImpl implements MemberService {

    //MemberMemoryRepository 구현체 직접 지정, 클라이언트가 의존하게 되어버리기떄문에 개발 원칙위반
    //추상화에도 의존하고 구체화에도 의존한다 -> NG (DIP 위반)
    private final MemberRepository memberRepository = new MemberMemoryRepository();

    @Override
    public void join(Member member) {
        //다형성의 원칙에 의해서 MemberMemoryRepository의 save 호출
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
