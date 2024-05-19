package danil.tiv.library.servicies;

import java.util.List;

import com.google.inject.Inject;

import danil.tiv.library.store.entities.StateOfBooksEntity;
import danil.tiv.library.store.repositories.StateOfBookRepository;

public class StateOfBookService {

	private final StateOfBookRepository stateOfBookRepository;
	
	@Inject
	public StateOfBookService(StateOfBookRepository stateOfBookRepository) {
		this.stateOfBookRepository = stateOfBookRepository;
	}
	
	public List<StateOfBooksEntity> findAllStateOfBook(){
		return stateOfBookRepository.findAllStateOfBook();
	}
	
    public StateOfBooksEntity getStateOfBookById(int id) {
        return stateOfBookRepository.findStateOfBookById(id);
    }

    public void addStateOfBook(StateOfBooksEntity stateofbook) {
    	stateOfBookRepository.saveStateOfBook(stateofbook);
    }

    public void updateStateOfBook(StateOfBooksEntity stateofbook) {
    	stateOfBookRepository.updateStateOfBook(stateofbook);
    }
    
    public void deleteStateOfBookById(int id) {
    	stateOfBookRepository.deleteStateOfBookById(id);
    }
}
