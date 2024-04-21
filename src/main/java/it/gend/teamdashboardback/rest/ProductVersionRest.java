package it.gend.teamdashboardback.rest;

import it.gend.teamdashboardback.entity.ProductVersion;
import it.gend.teamdashboardback.entity.TableRow;
import it.gend.teamdashboardback.service.DTO.RowsFromProductNamesDTO;
import it.gend.teamdashboardback.service.ProductVersionService;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
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
@RequestMapping("api/productVersion")
@Slf4j
public class ProductVersionRest {
 private final ProductVersionService productVersionService;

    public ProductVersionRest(ProductVersionService productVersionService) {
        this.productVersionService = productVersionService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<ProductVersion>> getAllProductVersions() {
        log.info("getAllProductVersions");
        return ResponseEntity.ok(productVersionService.getAllProductVersions());
    }

    @GetMapping("/team/{teamName}")
    public ResponseEntity<List<ProductVersion>> findProductVersionByTeamName(@PathVariable String teamName) {
        log.info("findProductVersionByTeamName");
        return ResponseEntity.ok(productVersionService.findProductVersionByTeamName(teamName));
    }

    @PostMapping("/add")
    public ResponseEntity<ProductVersion> addProductVersion(ProductVersion productVersion) {
        log.info("addProductVersion");
        return ResponseEntity.ok(productVersionService.addProductVersion(productVersion));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Boolean> deleteProductVersion(@PathVariable long id) {
        log.info("deleteProductVersion");
        return ResponseEntity.ok(productVersionService.deleteProductVersion(id));
    }

}
