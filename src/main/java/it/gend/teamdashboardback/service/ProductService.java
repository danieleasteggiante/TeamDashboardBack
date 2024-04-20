package it.gend.teamdashboardback.service;

import it.gend.teamdashboardback.entity.Product;
import it.gend.teamdashboardback.repository.ProductRepository;
import it.gend.teamdashboardback.utils.IdGenerator;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Daniele Asteggiante
 */
@Service
@Slf4j
@Transactional
public class ProductService {
    private final ProductRepository productRepository;
    private final IdGenerator idGenerator;

    public ProductService(ProductRepository productRepository, IdGenerator idGenerator) {
        this.productRepository = productRepository;
        this.idGenerator = idGenerator;
    }
    public List<Product> getAllProducts() {
        log.info("getAllProducts");
        return productRepository.findAll();
    }

    public Product addProduct(Product product) {
        log.info("addProduct");
        product.setId(idGenerator.getId(Product.class));
        return productRepository.save(product);
    }

    public Product findProductByName(String productName) {
        log.info("findProductByName");
        return productRepository.findByName(productName);
    }
}
