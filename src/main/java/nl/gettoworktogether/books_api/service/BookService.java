package nl.gettoworktogether.books_api.service;

import nl.gettoworktogether.books_api.model.Book;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

public interface BookService {

    public abstract long createBook(Book book);
    public abstract void updateBook(long id, Book book);
    public abstract void partialUpdateBook(long id, Map<String, String> fields);
    public abstract void deleteBook(long id);
    public abstract Collection<Book> getBooks(String title, String writer);
    public abstract Optional<Book> getBookById(long id);
    public abstract boolean bookExistsById(long id);

}
