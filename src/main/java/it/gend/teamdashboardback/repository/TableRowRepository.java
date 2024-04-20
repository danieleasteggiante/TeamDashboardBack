package it.gend.teamdashboardback.repository;

import it.gend.teamdashboardback.entity.TableRow;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Set;

/**
 * @author Daniele Asteggiante
 */
public interface TableRowRepository extends JpaRepository<TableRow, Long> {
}
