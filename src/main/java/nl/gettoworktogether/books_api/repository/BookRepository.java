package nl.gettoworktogether.books_api.repository;

import nl.gettoworktogether.books_api.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BookRepository extends JpaRepository<Book, Long> {

    Collection<Book> findAllByTitle(String title);
    Collection<Book> findAllByWriter(String name);
    Collection<Book> findAllByTitleAndWriter(String title, String writer);

}
