package hello.core.member;

import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

//역할-구현에서 구현
@Component  //Bean 등록 안해도 @ComponentScan에서 알아서 빈 등록 해줌
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
