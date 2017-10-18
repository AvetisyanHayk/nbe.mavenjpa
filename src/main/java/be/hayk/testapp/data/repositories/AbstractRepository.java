package be.hayk.testapp.data.repositories;

import be.hayk.testapp.filters.JPAFilter;
import javax.persistence.EntityManager;

/**
 *
 * @author Hayk
 */
abstract class AbstractRepository {

    protected EntityManager getEntityManager() {
        return JPAFilter.getEntityManager();
    }
}
