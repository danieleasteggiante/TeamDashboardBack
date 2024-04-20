package it.gend.teamdashboardback.repository;

import it.gend.teamdashboardback.entity.ProductVersion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @author Daniele Asteggiante
 */
public interface ProductVersionRepository extends JpaRepository<ProductVersion, Long> {
    List<ProductVersion> findAllByTeamName(String teamName);
}
