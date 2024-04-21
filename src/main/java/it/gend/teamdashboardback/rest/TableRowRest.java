package it.gend.teamdashboardback.rest;

import it.gend.teamdashboardback.entity.TableRow;
import it.gend.teamdashboardback.service.DTO.RowsFromProductNamesDTO;
import it.gend.teamdashboardback.service.TableRowService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Daniele Asteggiante
 */
@RestController
@RequestMapping("api/tableRow")
@Slf4j
public class TableRowRest {
    private final TableRowService tableRowService;

    public TableRowRest(TableRowService tableRowService) {
        this.tableRowService = tableRowService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<TableRow>> getAllTableRows() {
        log.info("getAllTableRows");
        return ResponseEntity.ok(tableRowService.getAllProducts());
    }

    @PostMapping("/allFromProduct")
    public ResponseEntity<RowsFromProductNamesDTO> getAllTableRowsFromProduct(List<String> products) {
        log.info("getAllTableRowsFromProduct");
        return ResponseEntity.ok(tableRowService.findAllFromProductNameIn(products));
    }


}
