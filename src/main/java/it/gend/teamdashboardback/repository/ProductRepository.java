package it.gend.teamdashboardback.repository;

import it.gend.teamdashboardback.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Daniele Asteggiante
 */
public interface ProductRepository extends JpaRepository<Product, Long> {
    Product findByName(String productName);
}
