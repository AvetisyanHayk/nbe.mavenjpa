package be.hayk.testapp.domain;

import java.io.Serializable;
import java.util.Locale;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Hayk
 */
@Entity
@Table(name = "testentity")
public class TestEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String name;
    private String description;

    protected TestEntity() {}
    
    public TestEntity(long id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 37 * hash + Objects.hashCode(name.toLowerCase(Locale.ENGLISH));
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final TestEntity other = (TestEntity) obj;
        return name.equalsIgnoreCase(other.name);
    }

    @Override
    public String toString() {
        return new StringBuilder()
                .append(name).append(": ")
                .append(description)
                .toString();
    }
}
