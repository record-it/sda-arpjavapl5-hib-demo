package app;

import dao.CarDao;
import dao.GenericDao;
import entity.*;

import javax.persistence.Persistence;
import java.math.BigDecimal;
import java.sql.Timestamp;

public class AssociationDemoApp {
    public static void main(String[] args) {
        GenericDao<Tool> tools = new GenericDao<>(
                Persistence.createEntityManagerFactory("hib-demo"),
                Tool.class
        );
        GenericDao<Person> persons =
                new GenericDao<>(Persistence.createEntityManagerFactory("hib-demo"), Person.class);
        final Person person = Person
                .builder()
                .firstName("Ewa")
                .lastName("Kowal")
                .address(
                        Address
                                .builder()
                                .street("Wiązowa 13/45a")
                                .city("Kalisz")
                                .zipCode("24-890")
                                .build()
                )
                .build();
        //persons.insert(person);
        persons.findAll().forEach(System.out::println);
        GenericDao<Student> students = new GenericDao<>(
                Persistence.createEntityManagerFactory("hib-demo"), Student.class
        );
        final Student student = Student.builder()
                .email("adam@sda.pl")
                .name("Adam Karolak")
                .album(
                        Album.builder()
                                .number(343434)
                                .build()
                )
                .build();
        students.insert(student);
        GenericDao<Worker> workers = new GenericDao<>(
                Persistence.createEntityManagerFactory("hib-demo"),
                Worker.class
        );
        CarDao cars = new CarDao(
                Persistence.createEntityManagerFactory("hib-demo"),
                Car.class
        );
        final Worker worker = Worker
                .builder()
                .salary(200)
                .position("magazynier")
                .departmentName("Magazyny")
                .car(null)
                .build();
        cars.insert(
                Car
                        .builder()
                        .price(new BigDecimal("40000"))
                        .power(100)
                        .model("Fiat 500")
                        .build()
        );

        workers.insert(worker);
        workers.insert(
                Worker
                        .builder()
                        .position("kierownik")
                        .salary(6000)
                        .departmentName("Rozliczenia")
                        .car(cars.find(1))
                        .build()
        );
        workers.insert(
                Worker
                        .builder()
                        .position("menadżer")
                        .salary(6000)
                        .departmentName("Rozliczenia")
                        .car(null)
                        .build()
        );
        tools.insert(
                Tool
                        .builder()
                        .name("młotek")
                        .worker(workers.find(1))
                        .build()
        );
        Worker entity = workers.find(1);
        entity.getTools().add(Tool.builder().name("świder").build());
        workers.update(entity.getId(), entity);
        System.out.println(workers.find(1));

    }
}
