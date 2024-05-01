package danil.tiv.library.store.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import danil.tiv.library.store.entities.BooksEntity;
import danil.tiv.library.store.repositories.BookRepository;
import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityTransaction;

import java.util.List;

public class BookDao implements BookRepository {

    private SessionFactory sessionFactory;

    public BookDao(SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    @Override
    public List<BooksEntity> findAllBooks() {
        try (Session session = sessionFactory.openSession()) {
            return session.createQuery("FROM BookEntity", BooksEntity.class).list();
        }
    }

    @Override
    public BooksEntity findBookById(int id) {
        try (Session session = sessionFactory.openSession()) {
            return session.get(BooksEntity.class, id);
        }
    }

    @Override
    public void saveBook(BooksEntity book) {
        try (Session session = sessionFactory.openSession()) {
            Transaction transaction = session.beginTransaction();
            session.persist(book);
            transaction.commit();
        }
    }

    @Override
    public void deleteBookById(int id) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            Query<BooksEntity> query = (Query<BooksEntity>) entityManager.createQuery("DELETE FROM BooksEntity b WHERE b.id = :id", BooksEntity.class);
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

    @Override
    public void updateBook(BooksEntity updatedBook) {
        EntityManager entityManager = sessionFactory.createEntityManager();
        EntityTransaction transaction = null;
        try {
            transaction = entityManager.getTransaction();
            transaction.begin();
            entityManager.merge(updatedBook);
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


