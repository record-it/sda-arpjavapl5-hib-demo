package app;

import dao.GenericDao;
import entity.*;

import javax.persistence.Persistence;
import java.sql.Timestamp;

public class AssociationDemoApp {
    public static void main(String[] args) {
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
        final Worker worker = Worker
                .builder()
                .salary(2000)
                .position("magazynier")
                .car(null)
                .build();
        workers.insert(worker);
    }
}
