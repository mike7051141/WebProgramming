package webp.webp.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import webp.webp.domain.Member;

import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long> {
    // 이미 생성된 사용자인지 처음 가입하는 사용인지 판단
    Optional<Member> findByEmailAndProvider(String email, String provider);
}
