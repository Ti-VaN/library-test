package danil.tiv.library.store.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import danil.tiv.library.store.entities.StateOfBooksEntity;
import danil.tiv.library.store.repositories.StateOfBookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class StateOfBookDao implements StateOfBookRepository {

    private SessionFactory sessionFactory;

    public StateOfBookDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<StateOfBooksEntity> findAllStateOfBook() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM StateOfBooksEntity", StateOfBooksEntity.class).list();
        }
    }

    @Override
    public StateOfBooksEntity findStateOfBookById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(StateOfBooksEntity.class, id);
        }
    }

    @Override
    public void saveStateOfBook(StateOfBooksEntity stateOfBook) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(stateOfBook);
            transaction.commit();
        }
    }

    @Override
    public void updateStateOfBook(StateOfBooksEntity stateOfBook) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(stateOfBook);
            transaction.commit();
        }
    }

    @Override
    public void deleteStateOfBookById(int id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query<StateOfBooksEntity> query = (Query<StateOfBooksEntity>) entityManager.createQuery("DELETE FROM StateOfBooksEntity s WHERE s.id = :id", StateOfBooksEntity.class);
            query.setParameter("id", id);
            query.executeUpdate();
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
