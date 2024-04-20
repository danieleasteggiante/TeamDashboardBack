package it.gend.teamdashboardback.rest;

import it.gend.teamdashboardback.entity.Product;
import it.gend.teamdashboardback.service.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author Daniele Asteggiante
 */
@RestController
@RequestMapping("api/product")
@Slf4j
public class ProductRest {
    private final ProductService productService;

    public ProductRest(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public ResponseEntity<List<Product>> getAllProduct() {
        log.info("getAllProduct");
        return ResponseEntity.ok(productService.getAllProducts());
    }

    @PostMapping("/add")
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        log.info("addProduct");
        return ResponseEntity.ok(productService.addProduct(product));
    }

    @GetMapping("/find/{productName}")
    public ResponseEntity<Product> findProduct(@PathVariable String productName) {
        log.info("findProduct");
        return ResponseEntity.ok(productService.findProductByName(productName));
    }

}