package it.gend.teamdashboardback.repository;

import it.gend.teamdashboardback.entity.JobDescription;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Daniele Asteggiante
 */
public interface JobDescriptionRepository extends JpaRepository<JobDescription, Long> {
}
