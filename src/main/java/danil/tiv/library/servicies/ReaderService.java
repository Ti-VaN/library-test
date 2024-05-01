package danil.tiv.library.servicies;

import java.util.List;

import com.google.inject.Inject;

import danil.tiv.library.store.entities.ReadersEntity;
import danil.tiv.library.store.repositories.ReaderRepository;


public class ReaderService {

	private final ReaderRepository readerRepository;

	@Inject
    public ReaderService(ReaderRepository readerRepository) {
        this.readerRepository = readerRepository;
    }
	
	public ReaderService() {
	       this.readerRepository = null; 
	}
	
    public List<ReadersEntity> findAllReaders() {
        return readerRepository.findAllReaders();
    }

    public ReadersEntity getReaderById(int id) {
        return readerRepository.findReaderById(id);
    }

    public void addReader(ReadersEntity reader) {
    	readerRepository.saveReader(reader);
    }

    public void deleteReaderById(int id) {
    	readerRepository.deleteReaderById(id);
    }
}
