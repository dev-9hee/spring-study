package hello.hello_spring.repository;

import hello.hello_spring.domain.Member;

import java.util.List;
import java.util.Optional;

// 회원 객체를 저장하는 저장소
public interface MemberRepository {

    Member save(Member member); // 회원을 저장하면 저장된 회원 반환, 회원이 저장소에 저장
    // Optional 은 findById, findByName 실행 시 Null 일 경우 Optional 로 감싸서 반환, 더 선호되는 방법
    Optional<Member> findById(long id); // 아이디 찾기
    Optional<Member> findByName(String name); // 이름 찾기
    List<Member> findAll(); // 저장된 모든 회원 리스트 반환

}
