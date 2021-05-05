package hello.core.member;

import java.util.HashMap;
import java.util.Map;

//역할-구현에서 구현
public class MemberMemoryRepository implements MemberRepository {

    //MemoryDB -> For Test
    //동시성 이슈 때문에 실무에서는 concurrentHashmap 사용
    private static Map<Long, Member> store = new HashMap<>();

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }
}
