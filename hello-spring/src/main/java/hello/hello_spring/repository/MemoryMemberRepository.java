package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.*;

public class MemoryMemberRepository implements MemberRepository { // alt + enter

    private static Map<Long, Member> store = new HashMap<>(); // Map 을 이용하여 회원 정보 저장
    private static long sequence = 0L; // 0, 1, 2 ...

    @Override
    public Member save(Member member) { // 새로운 회원을 저장하고, 저장된 객체를 반환
        member.setId(++sequence); // sequence 값을 증가시킨 후, 이를 Member 객체의 ID로 설정
        store.put(member.getId(), member); // store 맵에 Member 객체를 저장하고
        return member; // 저장된 객체를 반환
    }

    @Override
    public Optional<Member> findById(long id) { // 특정 ID로 회원을 조회
        return Optional.ofNullable(store.get(id)); // 주어진 ID로 store 맵에서 Member 객체를 찾음
        // 해당 ID에 맞는 객체가 존재하면 Optional 에 포함하여 반환하고, 없으면 Optional.empty()를 반환
    }

    @Override
    public Optional<Member> findByName(String name) { // 이름을 기준으로 회원을 조회
        return store.values().stream() // store 에 저장된 모든 Member 객체를 스트림으로 처리
                .filter(member -> member.getName().equals(name)) // 이름이 주어진 name 과 일치하는 첫 번째 Member 객체를 찾음
                .findAny();
    }

    @Override
    public List<Member> findAll() { // 저장된 모든 회원 정보를 리스트로 반환
        return new ArrayList<>(store.values()); // member 들
    }

    // 테스트 끝날때마다 리포지토리 깔끔하게 지워주는거 필요
    public void clearStore() {
        store.clear(); // 스토어 비움
    }
}
