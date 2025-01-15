package project.restapichat.domain.Member.member.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import project.restapichat.domain.Member.member.entity.Member;

@Repository
public interface MemberRepository extends JpaRepository<Member, Long> {
}
