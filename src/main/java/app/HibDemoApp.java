package app;

import entity.Car;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.math.BigDecimal;

public class HibDemoApp {
    public static void main(String[] args) {
        final EntityManagerFactory factory =
                Persistence.createEntityManagerFactory("hib-demo");
        //Tworzymy nowy obiekt o nieistniejącym id, w tym przypadku o id = 0
        Car car = new Car();
        car.setPower(125);
        car.setPrice(new BigDecimal("45000"));
        car.setAvailable(true);
        car.setModel("AAA");
        mergeCar(factory, car);
        //Tworzymy nowy obiekt o istniejącym id, w tym przypadku o id = 2
        car = new Car();
        car.setId(2);
        car.setPower(125);
        car.setPrice(new BigDecimal("45000"));
        car.setAvailable(true);
        car.setModel("AAA");
        mergeCar(factory, car);

//        insertCar(factory);
//        updatePowerCar(factory, 3, 150);
//        final Car car = findCar(factory, 4);
//        if (car != null) {
//            System.out.println("Car: " + car.getId() + ", " + car.getModel() + ", " + car.getPower());
//        } else {
//            System.out.println("Brak takiego auta!");
//        }
//        deleteCar(factory, 1);
    }

    private static void insertCar(EntityManagerFactory factory) {
        final EntityManager em = factory.createEntityManager();
        final Car car = new Car();
        car.setPower(200);
        car.setModel("Fiat 500");
        car.setPrice(new BigDecimal("34999.99"));
        car.setAvailable(false);
        final EntityTransaction transaction = em.getTransaction();
        transaction.begin();
        em.persist(car);
        transaction.commit();
        em.close();
    }

    private static void updatePowerCar(EntityManagerFactory factory, long id, double newPower) {
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        final Car car = em.find(Car.class, id); //pobieramy auto z bazy o podanym id
        car.setPower(newPower);                 //zmiana mocy w aucie
        em.getTransaction().commit();           //zatwierdzenie zmian
        em.close();
    }

    private static Car findCar(EntityManagerFactory factory, long id) {
        final EntityManager em = factory.createEntityManager();
        final Car car = em.find(Car.class, id);
        em.close();
        return car;     //UWAGA!!! zwracane auto jest odłączone (detach) od em!!!!
    }
    
    private static void deleteCar(EntityManagerFactory factory, long id){
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        em.remove(em.find(Car.class, id));      //musimy najpierw wyszukać usuwany obiekt!!!
        em.getTransaction().commit();
        em.close();
    }

    private static void mergeCar(EntityManagerFactory factory, Car car){
        final EntityManager em = factory.createEntityManager();
        em.getTransaction().begin();
        final Car mergeCar = em.merge(car); //mergeCar jest encja zarządzaną
        car.setModel("BBBBBB");             //car nie jest encją zarządzaną, zmiana nie zostanie uwzglęniona w bazie
        System.out.println("Id w car " + car.getId());
        System.out.println("Id w mergeCar " + mergeCar.getId());
        em.getTransaction().commit();
        em.close();
    }
}
