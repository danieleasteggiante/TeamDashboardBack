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
    private final ProductVersionService productVersionService;

    public TableRowService(TableRowRepository tableRowRepository, ProductVersionService productVersionService) {
        this.tableRowRepository = tableRowRepository;
        this.productVersionService = productVersionService;
    }
    public List<TableRow> getAllProducts() {
        return tableRowRepository.findAll();
    }

    public RowsFromProductNamesDTO findAllFromProductNameIn(List<String> products) {
        List<TableRow> tableRows = tableRowRepository.findAll();
        RowsFromProductNamesDTO rowsFromProductNamesDTOS = new RowsFromProductNamesDTO();
        for (TableRow row : tableRows) {
            if(!checkIfKeyAlreadyExists(rowsFromProductNamesDTOS, row))
                addProductToMap(rowsFromProductNamesDTOS, row, products);
        }
        return rowsFromProductNamesDTOS;
    }

    private void addProductToMap(RowsFromProductNamesDTO rowsFromProductNamesDTOS, TableRow row, List<String> products) {
        Set<RowsFromProductNamesDTO.ProductVersionDTO> productVersions = new LinkedHashSet<>();
        for (String product : products) {
            boolean isPresent = false;
            for (ProductVersion pV : row.getProductVersions()) {
                isPresent = pV.getProduct().getName().equals(product);
                addIfPresent(productVersions, pV, product);
            }
            if (!isPresent) addPlaceholder(productVersions, product);
        }
        rowsFromProductNamesDTOS.getRowsFromProductNames().put(row, productVersions);
    }

    private void addPlaceholder(Set<RowsFromProductNamesDTO.ProductVersionDTO> productVersions, String productName) {
        ProductVersion pV = new ProductVersion();
        Product product = new Product();
        product.setName(productName + " - Placeholder");
        pV.setProduct(product);
        productVersions.add(mapToProductVersionDTO(pV));
    }

    private RowsFromProductNamesDTO.ProductVersionDTO mapToProductVersionDTO(ProductVersion pV) {
        return new RowsFromProductNamesDTO.ProductVersionDTO(pV.getProduct().getName(), pV.getVersion(), pV.getDescription());
    }

    private void addIfPresent(Set<RowsFromProductNamesDTO.ProductVersionDTO> productVersions, ProductVersion pV, String product) {
        if (pV.getProduct().getName().equals(product))
            productVersions.add(mapToProductVersionDTO(pV));
    }

    private boolean checkIfKeyAlreadyExists(RowsFromProductNamesDTO rowsFromProductNamesDTOS, TableRow row) {
        return rowsFromProductNamesDTOS.getRowsFromProductNames().containsKey(row);
    }

}
