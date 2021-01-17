package nl.gettoworktogether.books_api.repository;

import nl.gettoworktogether.books_api.model.Book;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Collection;

public interface BookRepository extends JpaRepository<Book, Long> {

    public Collection<Book> findAllByTitle(String title);
    public Collection<Book> findAllByWriter(String name);
    public Collection<Book> findAllByTitleAndWriter(String title, String writer);

}
