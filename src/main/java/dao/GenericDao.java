package dao;

import entity.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

public class GenericDao<T> {
    private final EntityManagerFactory factory;

    private final Class<T> clazz;

    public GenericDao(EntityManagerFactory factory, Class<T> clazz) {
        this.factory = factory;
        this.clazz = clazz;
    }

    public void insert(T obj) {
        final EntityManager em = factory.createEntityManager();
        final EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(obj);
        transaction.commit();
        em.close();
    }

    //UwaGA!!!
    //id i id w obj muszą być takie same!!!
    public void update(long id, T obj) {
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        final T exo = em.find(clazz, id);
        if (exo != null) {
            em.merge(obj);
        }
        em.getTransaction().commit();
        em.close();
    }

    public T find(long id) {
        final EntityManager em = factory.createEntityManager();
        T obj = em.find(clazz, id);
        em.close();
        return obj;
    }

    public void delete(long id) {
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        T obj = em.find(clazz, id);
        if (obj != null) {
            em.remove(obj);
        }
        em.getTransaction().commit();
        em.close();
    }
}
