package app;

import entity.Book;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

/*
 * 1. Stwórz klasę encji Book z polami: id, title, author, editionYear
 * 2. Napisz w klasie Ex1App kod, który:
 *   a. doda do bazy kilka książek (książki o danych wczytanych z klawiatury)
 *   b. zmodyfikuje jedną wybraną książkę np. rok edycji
 *   c. usuwa jedną wybraną książkę
 *   d. wyświetla informacje książki o podanym id
 */
public class Ex1App {
    static final EntityManagerFactory factory =
            Persistence.createEntityManagerFactory("hib-demo");
    public static void main(String[] args) {
        EntityManager em = factory.createEntityManager();
        List<Book> books = List.of(
                new Book(0, "AAA", "BBB", 2000),
                new Book(0, "GGG", "DDD", 2012),
                new Book(0, "BBB", "DDD", 2001)
        );
        em.getTransaction().begin();
        books.forEach(em::persist);


        em.getTransaction().commit();
        em.close();
    }
}
