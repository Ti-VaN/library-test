package danil.tiv.library.store.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import danil.tiv.library.store.entities.ReadersEntity;
import danil.tiv.library.store.repositories.ReaderRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

public class ReaderDao implements ReaderRepository{

    private SessionFactory sessionFactory;

    public ReaderDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<ReadersEntity> findAllReaders() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM ReadersEntity", ReadersEntity.class).list();
        }
    }

    @Override
    public ReadersEntity findReaderById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(ReadersEntity.class, id);
        }
    }

    @Override
    public void saveReader(ReadersEntity reader) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(reader);
            transaction.commit();
        }
    }

    @Override
    public void deleteReaderById(int id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.createQuery("DELETE FROM ReadersEntity r WHERE r.readerId = :id")
                         .setParameter("id", id)
                         .executeUpdate();
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }
    
    @Override
    public void updateReader(ReadersEntity updatedReader) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(updatedReader);
            transaction.commit();
        } catch (RuntimeException e) {
            if (transaction != null && transaction.isActive()) {
                transaction.rollback();
            }
            throw e;
        } finally {
            entityManager.close();
        }
    }
}
