package be.hayk.testapp.filters;

import java.io.IOException;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;

/**
 *
 * @author Hayk
 */
@WebFilter("*.htm")
public class JPAFilter implements Filter {

    private static final EntityManagerFactory ENTITY_MANAGER_FACTORY =
            Persistence.createEntityManagerFactory("testappdb");
    
    private static final ThreadLocal<EntityManager> ENTITY_MANAGERS =
            new ThreadLocal<>();
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        ENTITY_MANAGERS.set(ENTITY_MANAGER_FACTORY.createEntityManager());
        try {
            request.setCharacterEncoding("UTF-8");
            chain.doFilter(request, response);
        } finally {
            EntityManager entityManager = ENTITY_MANAGERS.get();
            if (entityManager.getTransaction().isActive()) {
                entityManager.getTransaction().rollback();
            }
            entityManager.close();
            ENTITY_MANAGERS.remove();
        }
    }

    @Override
    public void destroy() {
        ENTITY_MANAGER_FACTORY.close();
    }

    public static EntityManager getEntityManager() {
        return ENTITY_MANAGERS.get();
    }
}
