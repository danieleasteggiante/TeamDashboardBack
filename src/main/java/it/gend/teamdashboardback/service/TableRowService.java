package it.gend.teamdashboardback.service;

import it.gend.teamdashboardback.entity.TableRow;
import it.gend.teamdashboardback.repository.TableRowRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * @author Daniele Asteggiante
 */
@Service
@Slf4j
@Transactional
public class TableRowService {
    private final TableRowRepository tableRowRepository;

    public TableRowService(TableRowRepository tableRowRepository) {
        this.tableRowRepository = tableRowRepository;
    }
    public List<TableRow> getAllProducts() {
        return tableRowRepository.findAll();
    }

}
