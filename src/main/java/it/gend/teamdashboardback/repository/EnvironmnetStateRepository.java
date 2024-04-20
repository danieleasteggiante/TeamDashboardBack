package it.gend.teamdashboardback.repository;

import it.gend.teamdashboardback.entity.EnvironmentState;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Daniele Asteggiante
 */
public interface EnvironmnetStateRepository extends JpaRepository<EnvironmentState, Long> {
}
