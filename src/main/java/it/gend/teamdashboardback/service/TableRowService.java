package it.gend.teamdashboardback.service;

import it.gend.teamdashboardback.entity.Product;
import it.gend.teamdashboardback.entity.ProductVersion;
import it.gend.teamdashboardback.entity.TableRow;
import it.gend.teamdashboardback.repository.TableRowRepository;
import it.gend.teamdashboardback.service.DTO.RowsFromProductNamesDTO;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashSet;
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

    public List<RowsFromProductNamesDTO> findAllFromProductNameIn(List<String> products) {
        List<TableRow> tableRows = tableRowRepository.findAll();
        List<RowsFromProductNamesDTO> rowsFromProductNamesDTOS = new ArrayList<>();
        for (TableRow row : tableRows) {
            RowsFromProductNamesDTO rowsFromProductNamesDTO = new RowsFromProductNamesDTO();
            rowsFromProductNamesDTO.setTableRow(row);
            rowsFromProductNamesDTO.setRowsFromProductNames(createProductVersionDTOs(products, row));
        }
        return rowsFromProductNamesDTOS;
    }

    private Set<RowsFromProductNamesDTO.ProductVersionDTO> createProductVersionDTOs(List<String> products, TableRow row) {
        Set<RowsFromProductNamesDTO.ProductVersionDTO> productVersionDTOS = new LinkedHashSet<>();
        for (String product : products) {
            if (!addIfPresentInRow(product, row, productVersionDTOS))
                productVersionDTOS.add(new RowsFromProductNamesDTO.ProductVersionDTO(product, "placeholder", "placeholder"));
        }
        return productVersionDTOS;
    }

    private boolean addIfPresentInRow(String product, TableRow row, Set<RowsFromProductNamesDTO.ProductVersionDTO> productVersionDTOS) {
        Set<ProductVersion> productVersions = row.getProductVersions();
        for (ProductVersion productVersion : productVersions) {
            if (productVersion.getProduct().getName().equals(product)) {
                RowsFromProductNamesDTO.ProductVersionDTO productVersionDTO =
                           new RowsFromProductNamesDTO.ProductVersionDTO(productVersion.getProduct().getName(),productVersion.getVersion(), productVersion.getDescription());
                productVersionDTOS.add(productVersionDTO);
                return true;
            }
        }
        return false;
    }

}
