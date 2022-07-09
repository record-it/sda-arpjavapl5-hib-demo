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
        final EntityManager em = factory.createEntityManager();
        final List<Book> books = em
                .createQuery("select b from Book b where b.editionYear = :year order by b.author, b.title desc", Book.class)
                .setParameter("year", year)
                .getResultList();
        em.close();
        return books;
    }
    //Zdefiniuj metodę zwracającą liczbę książek z każdego roku wydania
    public List<Long> findCountByEditionYear(){
        final EntityManager em = factory.createEntityManager();
        final List<Long> list = em.createQuery("select count(b) from Book b group by b.editionYear", Long.class)
                .getResultList();
        em.close();
        return list;
    }
}
