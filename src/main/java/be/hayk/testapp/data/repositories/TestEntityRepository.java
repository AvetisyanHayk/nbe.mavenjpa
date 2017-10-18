package be.hayk.testapp.data.repositories;

import be.hayk.testapp.domain.TestEntity;
import java.util.List;

/**
 *
 * @author Hayk
 */
public class TestEntityRepository extends AbstractRepository {

    public TestEntity read(long id) {
        return getEntityManager().find(TestEntity.class, id);
    }

    public List<TestEntity> findAll() {
        return getEntityManager().createNamedQuery("TestEntity.findAll", TestEntity.class)
                .getResultList();
    }
}
