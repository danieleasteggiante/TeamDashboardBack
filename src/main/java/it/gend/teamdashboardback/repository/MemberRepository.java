package it.gend.teamdashboardback.repository;

import it.gend.teamdashboardback.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Daniele Asteggiante
 */
public interface MemberRepository extends JpaRepository<Member, Long> {
    Member findByNameLikeIgnoreCase(String name);
}
