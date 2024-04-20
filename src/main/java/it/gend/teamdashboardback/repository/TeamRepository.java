package it.gend.teamdashboardback.repository;

import it.gend.teamdashboardback.entity.Team;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Daniele Asteggiante
 */
public interface TeamRepository extends JpaRepository<Team, Long> {
}
