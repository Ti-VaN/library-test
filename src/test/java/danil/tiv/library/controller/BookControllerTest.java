package danil.tiv.library.controller;

import java.time.LocalDate;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import danil.tiv.library.controllers.BookController;
import danil.tiv.library.servicies.BookService;
import danil.tiv.library.store.entities.BooksEntity;
import jakarta.ws.rs.core.Response;

public class BookControllerTest {

	private BookService bookService;
    private BookController bookController;

    @Before
    public void setUp() {
        bookService = mock(BookService.class);
        bookController = new BookController(bookService);
    }

    @Test
    public void testGetBookById() {

        BooksEntity book = new BooksEntity(1, "Book1", "Author1", LocalDate.of(2022, 1, 1), 5);

        when(bookService.getBookById(1)).thenReturn(book);

        Response response = bookController.getBookById(1);

        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
        BooksEntity result = (BooksEntity) response.getEntity();
        assertEquals("Book1", result.getBookName());
        assertEquals("Author1", result.getAuthor());
        assertEquals(LocalDate.of(2022, 1, 1), result.getYearBook());
        assertEquals(5, result.getCountBook());
    }

    @Test
    public void testAddBook() {

        BooksEntity book = new BooksEntity(1, "Book1", "Author1", LocalDate.of(2022, 1, 1), 5);
        Response response = bookController.addBook(book);
        assertEquals(Response.Status.CREATED.getStatusCode(), response.getStatus());
    }

    @Test
    public void testUpdateBook() {

        BooksEntity book = new BooksEntity(1, "Book1", "Author1", LocalDate.of(2022, 1, 1), 5);
        Response response = bookController.updateBook(1, book);
        assertEquals(Response.Status.OK.getStatusCode(), response.getStatus());
    }

    @Test
    public void testDeleteBook() {
    	
        Response response = bookController.deleteBook(1);

        assertEquals(Response.Status.NO_CONTENT.getStatusCode(), response.getStatus());
    }
	
}
