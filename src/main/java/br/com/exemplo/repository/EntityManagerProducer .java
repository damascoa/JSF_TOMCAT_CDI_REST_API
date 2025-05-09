package br.com.exemplo.repository;





import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

@ApplicationScoped
class EntityManagerProducer {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("defaultPU");

    @Produces
    @ApplicationScoped
    public EntityManager createEntityManager() {
        return emf.createEntityManager();
    }
}