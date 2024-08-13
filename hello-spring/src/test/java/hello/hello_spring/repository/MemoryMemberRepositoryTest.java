package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {

    MemoryMemberRepository repository = new MemoryMemberRepository();

    // 테스트 끝날때마다 리포지토리 깔끔하게 지워주는거 필요, 테스트들은 서로 의존 관계없이 설계가 되어야 함
    @AfterEach
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save() {
        Member member = new Member();
        member.setName("spring");

        repository.save(member); // 저장한거

        Member result = repository.findById(member.getId()).get(); // db 에서 꺼낸거
//        Assertions.assertEquals(member, result); // 기대한값 member, 들어온값 result 가 기대한 값과 같은지
        assertThat(member).isEqualTo(result);
    }

    @Test
    public void findByName() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member(); // shift + f6 : rename
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring1").get(); // get()을 사용하는 이유 : Optional 까서 안의 값 가져옴

        assertThat(result).isEqualTo(member1);
    }

    @Test
    public void findAll() {
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(2); // size 는 2개가 나와야 함
    }
}
