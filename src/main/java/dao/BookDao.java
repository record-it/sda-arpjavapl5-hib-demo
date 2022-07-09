package dao;

import entity.Book;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.List;

public class BookDao extends GenericDao<Book>{
    public BookDao(EntityManagerFactory factory, Class<Book> clazz) {
        super(factory, clazz);
    }
    //Zdefiiuj metodę zwracającą książki opublikowane w podanym roku
    public List<Book> findPublishedInYear(int year){

    }
}
