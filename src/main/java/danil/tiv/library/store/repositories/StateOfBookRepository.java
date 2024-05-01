package danil.tiv.library.store.repositories;

import java.util.List;

import danil.tiv.library.store.entities.StateOfBooksEntity;

public interface StateOfBookRepository {

	List<StateOfBooksEntity> findAllStateOfBook();
	
	StateOfBooksEntity findStateOfBookById(int id);
	 
	void saveStateOfBook(StateOfBooksEntity stateofbook);
	 
	void updateStateOfBook(StateOfBooksEntity stateofBook);
	
	void deleteStateOfBookById(int id); 

}
