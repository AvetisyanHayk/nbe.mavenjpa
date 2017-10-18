package be.hayk.testapp.data.services;

import be.hayk.testapp.filters.JPAFilter;
import javax.persistence.EntityManager;

/**
 *
 * @author Hayk
 */
abstract class AbstractService {

    private EntityManager getEntityManager() {
        return JPAFilter.getEntityManager();
    }

    protected void begin() {
        getEntityManager().getTransaction().begin();
    }

    protected void commit() {
        getEntityManager().getTransaction().commit();
    }

    protected void rollback() {
        getEntityManager().getTransaction().rollback();
    }
}
