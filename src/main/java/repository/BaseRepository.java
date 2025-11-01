package repository;


import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class BaseRepository {
    protected static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("StudentRegisterCoursePU");

    protected EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
}