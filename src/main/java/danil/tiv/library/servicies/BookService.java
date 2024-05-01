package danil.tiv.library.servicies;

import java.util.List;

import com.google.inject.Inject;

import danil.tiv.library.store.entities.BooksEntity;
import danil.tiv.library.store.repositories.BookRepository;

public class BookService {

	private final BookRepository bookRepository;

	@Inject
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

	public BookService() {
	       this.bookRepository = null; 
	}
	
    public List<BooksEntity> findAllBooks() {
        return bookRepository.findAllBooks();
    }

    public BooksEntity getBookById(int id) {
        return bookRepository.findBookById(id);
    }

    public void addBook(BooksEntity book) {
        bookRepository.saveBook(book);
    }
    
    public void deleteBookById(int id) {
        bookRepository.deleteBookById(id);
    }
}
