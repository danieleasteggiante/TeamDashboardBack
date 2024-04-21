package it.gend.teamdashboardback.service;

import it.gend.teamdashboardback.entity.ProductVersion;
import it.gend.teamdashboardback.repository.ProductVersionRepository;
import it.gend.teamdashboardback.service.DTO.RowsFromProductNamesDTO;
import it.gend.teamdashboardback.utils.IdGenerator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.swing.*;
import java.util.List;

/**
 * @author Daniele Asteggiante
 */
@Service
@Slf4j
@Transactional
public class ProductVersionService {
    private final ProductVersionRepository productVersionRepository;
    private final IdGenerator idGenerator;

    public ProductVersionService(ProductVersionRepository productVersionRepository, IdGenerator idGenerator) {
        this.productVersionRepository = productVersionRepository;
        this.idGenerator = idGenerator;
    }

    public List<ProductVersion> getAllProductVersions() {
        return productVersionRepository.findAll();
    }

    public ProductVersion addProductVersion(ProductVersion productVersion) {
        productVersion.setId(idGenerator.getId(ProductVersion.class));
        return productVersionRepository.save(productVersion);
    }

    public List<ProductVersion> findProductVersionByTeamName(String teamName) {
        return productVersionRepository.findAllByTeamName(teamName);
    }


    public boolean deleteProductVersion(long id) {
        ProductVersion productVersion = productVersionRepository.findById(id).orElseThrow();
        productVersionRepository.delete(productVersion);
        return true;
    }
}
