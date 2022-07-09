package dao;

import entity.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class CarDao extends GenericDao<Car>{
    public CarDao(EntityManagerFactory factory, Class<Car> clazz) {
        super(factory, clazz);
    }

    public List<Car> findAll(){
        final EntityManager em = this.factory.createEntityManager();
        final List<Car> list = em.createQuery("select c from Car c", Car.class).getResultList();
        em.close();
        return list;
    }
}
