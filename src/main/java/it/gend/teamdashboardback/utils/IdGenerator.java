package it.gend.teamdashboardback.utils;

import jakarta.persistence.EntityManager;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

/**
 * @author Daniele Asteggiante
 */
@Service
@Transactional
public class IdGenerator {
    private final EntityManager entityManager;

    public IdGenerator(EntityManager entityManager) {
        this.entityManager = entityManager;
    }
    public <T> Long getId(Class<T> entityClass) {
        Query query = entityManager.createQuery("SELECT MAX(e.id) FROM " + entityClass.getSimpleName() + " e");
        Long maxId = (Long) query.getSingleResult();
        return maxId == null || maxId == 0 ? 1L : maxId + 1L;
    }
}
