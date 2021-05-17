package hello.core.member;

//구현체 하나의 경우에는 MemberServiceImpl 관례상 사용
public class MemberServiceImpl implements MemberService {

    //MemberMemoryRepository 구현체 직접 지정, 클라이언트가 의존하게 되어버리기떄문에 개발 원칙위반
    //추상화에도 의존하고 구체화에도 의존한다 -> NG (DIP 위반)
    //private final MemberRepository memberRepository = new MemberMemoryRepository(); -> AppConfig에서 관리하도록 수정
    private final MemberRepository memberRepository;    //-> 추상화에만 의존 DIP 성립, 생성자를 통해서 주입(뭐가 들어올지는 오직 외부에서 결정)

    //구현체가 뭐가 들어갈지는 생성자를 통해서 주입 해준다.
    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        //다형성의 원칙에 의해서 MemberMemoryRepository의 save 호출
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }

    /**
     * For Test(Singleton)
     */
    public MemberRepository getMemberRepository() {
        return memberRepository;
    }
}
