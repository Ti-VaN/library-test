package danil.tiv.library.controllers;

import java.util.List;

import danil.tiv.library.servicies.BookService;
import danil.tiv.library.store.entities.BooksEntity;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;

import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/books")
@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class BookController {

	private final BookService bookService;

    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @GET
    public List<BooksEntity> getAllBooks() {
        return bookService.findAllBooks();
    }

    @GET
    @Path("/{id}")
    public Response getBookById(@PathParam("id") int id) {
    	BooksEntity book = bookService.getBookById(id);
        if (book != null) {
            return Response.ok(book).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    public Response addBook(BooksEntity book) {
        bookService.addBook(book);
        return Response.status(Response.Status.CREATED).build();
    }

    @PUT
    @Path("/{id}")
    public Response updateBook(@PathParam("id") int id, BooksEntity book) {
        book.setBookId(id); 
        bookService.addBook(book);
        return Response.ok().build();
    }

    @DELETE
    @Path("/{id}")
    public Response deleteBook(@PathParam("id") int id) {
        bookService.deleteBookById(id);
        return Response.noContent().build();
    }
}
