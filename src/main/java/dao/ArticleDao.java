package dao;

import entity.Article;
import entity.Author;
import entity.Tag;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class ArticleDao extends GenericDao<Article> {
    public ArticleDao(EntityManagerFactory factory, Class<Article> clazz) {
        super(factory, clazz);
    }

    public List<Tag> findAllTagsForArticlesWithTitle(String title){
        EntityManager em = factory.createEntityManager();
        final Set<Tag> tags =
                em.createQuery("select t from Article a left join a.tags t with t.name not in('Database') where a.title = :title", Tag.class)
                        .setParameter("title", title)
                        .getResultStream().collect(Collectors.toSet());
        em.close();
        return new ArrayList<>(tags);
    }

    public List<Author> findAllAuthorsForArticleWithTitle(String title){
        EntityManager em = factory.createEntityManager();
        final List<Author> tags =
                em.createQuery("select t from Article a left join a.authors t where a.title = :title", Author.class)
                        .setParameter("title", title)
                        .getResultList();
        em.close();
        return tags;
    }

}
