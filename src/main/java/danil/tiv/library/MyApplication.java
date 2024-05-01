package danil.tiv.library;

import org.hibernate.SessionFactory;

import danil.tiv.library.controllers.BookController;
import danil.tiv.library.controllers.ReaderController;
import danil.tiv.library.controllers.StateOfBookController;
import danil.tiv.library.servicies.BookService;
import danil.tiv.library.servicies.ReaderService;
import danil.tiv.library.servicies.StateOfBookService;
import danil.tiv.library.store.dao.ReaderDao;
import danil.tiv.library.store.dao.BookDao;
import danil.tiv.library.store.dao.StateOfBookDao;
import danil.tiv.library.store.repositories.*;


public class MyApplication {
	
    private BookController bookController;
    private ReaderController readerController;
    private StateOfBookController stateOfBookController;
	
    public static void main(String[] args) {
   
        MyApplication app = new MyApplication();
        app.run();
    }

    public MyApplication() {
        SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

        BookRepository bookRepository = new BookDao(sessionFactory);
        ReaderRepository readerRepository = new ReaderDao(sessionFactory);
        StateOfBookRepository stateOfBookRepository = new StateOfBookDao(sessionFactory);

        BookService bookService = new BookService(bookRepository);
        ReaderService readerService = new ReaderService(readerRepository);
        StateOfBookService stateOfBookService = new StateOfBookService(stateOfBookRepository);

        this.bookController = new BookController(bookService);
        this.readerController = new ReaderController(readerService);
        this.stateOfBookController = new StateOfBookController(stateOfBookService);
    }

    public void run() {
    	//
    }
}
