package nl.gettoworktogether.books_api.service;

import nl.gettoworktogether.books_api.exceptions.RecordNotFoundException;
import nl.gettoworktogether.books_api.model.Book;
import nl.gettoworktogether.books_api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public long createBook(Book book) {
        Book newBook = bookRepository.save(book);
        return newBook.getId();
    }

    @Override
    public void updateBook(long id, Book book) {
        if (!bookRepository.existsById(id)) throw new RecordNotFoundException();
        Book existingBook = bookRepository.findById(id).get();
        existingBook.setTitle(book.getTitle());
        existingBook.setWriter(book.getWriter());
        existingBook.setIsbn(book.getIsbn());
        bookRepository.save(existingBook);
    }

    @Override
    public void partialUpdateBook(long id, Map<String, String> fields) {
        if (!bookRepository.existsById(id)) throw new RecordNotFoundException();
        Book book = bookRepository.findById(id).get();
        for (String field : fields.keySet()) {
            switch (field.toLowerCase()) {
                case "title":
                    book.setTitle((String) fields.get(field));
                    break;
                case "writer":
                    book.setWriter((String) fields.get(field));
                    break;
                case "isbn":
                    book.setIsbn((String) fields.get(field));
                    break;
            }
        }
        bookRepository.save(book);
    }


    @Override
    public void deleteBook(long id) {
        if (!bookRepository.existsById(id)) throw new RecordNotFoundException();
        bookRepository.deleteById(id);
    }

    @Override
    public Collection<Book> getBooks(String title, String writer) {
        if (!title.isEmpty()) {
            if (!writer.isEmpty()) {
                return bookRepository.findAllByTitleAndWriter(title, writer);
            }
            else {
                return bookRepository.findAllByTitle(title);
            }
        }
        else {
            if (!writer.isEmpty()) {
                return bookRepository.findAllByWriter(writer);
            }
            else {
                return bookRepository.findAll();
            }
        }
    }

    @Override
    public Optional<Book> getBookById(long id) {
        if (!bookRepository.existsById(id)) throw new RecordNotFoundException();
        return bookRepository.findById(id);
    }

    @Override
    public boolean bookExistsById(long id) {
        return bookRepository.existsById(id);
    }
}
