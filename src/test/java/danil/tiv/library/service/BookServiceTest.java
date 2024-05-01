package danil.tiv.library.service;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import java.time.LocalDate;

import danil.tiv.library.store.entities.BooksEntity;
import danil.tiv.library.store.repositories.BookRepository;
import danil.tiv.library.servicies.BookService;

public class BookServiceTest {

    private BookRepository bookRepository;
    private BookService bookService;

    @Before
    public void setUp() {
        bookRepository = mock(BookRepository.class); 
        bookService = new BookService(bookRepository);
    }

    @Test
    public void testGetAllBooks() {

        List<BooksEntity> books = new ArrayList<>();
        books.add(new BooksEntity(1, "Book1", "Author1", LocalDate.of(2022, 1, 1), 5));
        books.add(new BooksEntity(2, "Book2", "Author2", LocalDate.of(2023, 2, 2), 3));

        when(bookRepository.findAllBooks()).thenReturn(books);

        List<BooksEntity> result = bookService.findAllBooks();

        assertEquals(2, result.size());
        assertEquals("Book1", result.get(0).getBookName());
        assertEquals("Author1", result.get(0).getAuthor());
        assertEquals(LocalDate.of(2022, 1, 1), result.get(0).getYearBook());
        assertEquals(5, result.get(0).getCountBook());
        assertEquals("Book2", result.get(1).getBookName());
        assertEquals("Author2", result.get(1).getAuthor());
        assertEquals(LocalDate.of(2023, 2, 2), result.get(1).getYearBook());
        assertEquals(3, result.get(1).getCountBook());
    }

    @Test
    public void testGetBookById() {

        BooksEntity book = new BooksEntity(1, "Book1", "Author1", LocalDate.of(2022, 1, 1), 5);

        when(bookRepository.findBookById(1)).thenReturn(book);

        BooksEntity result = bookService.getBookById(1);

        assertEquals("Book1", result.getBookName());
        assertEquals("Author1", result.getAuthor());
        assertEquals(LocalDate.of(2022, 1, 1), result.getYearBook());
        assertEquals(5, result.getCountBook());
    }

    @Test
    public void testAddBook() {

        BooksEntity bookToAdd = new BooksEntity(1, "Book1", "Author1", LocalDate.of(2022, 1, 1), 5);
        bookService.addBook(bookToAdd);
        verify(bookRepository, times(1)).saveBook(bookToAdd);
    }

    @Test
    public void testDeleteBookById() {

        bookService.deleteBookById(1);

        verify(bookRepository, times(1)).deleteBookById(1);
    }
}
