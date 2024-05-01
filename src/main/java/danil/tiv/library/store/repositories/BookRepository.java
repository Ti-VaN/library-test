package danil.tiv.library.store.repositories;

import java.util.List;

import danil.tiv.library.store.entities.BooksEntity;


public interface BookRepository {

	
	 List<BooksEntity> findAllBooks();
	 
	 BooksEntity findBookById(int id);
	 
	 void saveBook(BooksEntity book);
	 
	 void updateBook(BooksEntity updatedBook);
	 
	 void deleteBookById(int id);
	 
}
