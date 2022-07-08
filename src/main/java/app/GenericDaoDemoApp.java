package app;

import dao.GenericDao;
import entity.Book;
import entity.Car;

import javax.persistence.Persistence;
import java.math.BigDecimal;

public class GenericDaoDemoApp {
    public static void main(String[] args) {
        GenericDao<Car> carDao = new GenericDao<>(Persistence.createEntityManagerFactory("hib-demo"), Car.class);
//        Car car = new Car();
//        car.setModel("Dao model");
//        car.setAvailable(true);
//        car.setPrice(new BigDecimal("100000"));
//        car.setPower(1000);
//        carDao.insert(car);
        //Zadeklaruj bookDao i dodaj książkę
//        GenericDao<Book> bookDao = new GenericDao<>(Persistence.createEntityManagerFactory("hib-demo"), clazz);
//        Book book = new Book("Title dao", "Author dao", 2000);
//        bookDao.insert(book);
        final Car car = carDao.find(4);
        if (car != null) {
            System.out.println(car);
        } else {
            System.out.println("brak");
        }
        carDao.delete(5);
        if (carDao.find(5) == null){
            System.out.println("usunięto");
        }
        Car updateCar = carDao.find(4);
        if (updateCar != null) {
            updateCar.setPrice(new BigDecimal("400000"));
            carDao.update(updateCar.getId(), updateCar);
        }
    }
}
