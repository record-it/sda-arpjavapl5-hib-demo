package dao;

import entity.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.math.BigDecimal;
import java.util.List;

public class CarDao extends GenericDao<Car>{
    public CarDao(EntityManagerFactory factory, Class<Car> clazz) {
        super(factory, clazz);
    }

    public List<Car> findPriceGreater(BigDecimal limit){
        final EntityManager em = factory.createEntityManager();
        final List<Car> cars = em.createQuery("select c from Car c where c.price > :limit", Car.class)
                .setParameter("limit", limit)
                .getResultList();
        em.close();
        return cars;
    }
}
