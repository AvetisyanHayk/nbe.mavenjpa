package be.hayk.testapp.data.services;

import be.hayk.testapp.data.repositories.TestEntityRepository;
import be.hayk.testapp.domain.TestEntity;

/**
 *
 * @author Hayk
 */
public class TestEntityService extends AbstractService {

    private final TestEntityRepository repo = new TestEntityRepository();
    
    public TestEntity read(long id) {
        return repo.read(id);
    }
}
