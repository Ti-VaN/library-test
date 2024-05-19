package danil.tiv.library.store.repositories;

import java.util.List;

import danil.tiv.library.store.entities.ReadersEntity;


public interface ReaderRepository {

	 List<ReadersEntity> findAllReaders();
	 
	 ReadersEntity findReaderById(int id);
	 
	 void saveReader(ReadersEntity reader);
	 
	 void updateReader(ReadersEntity reader);
	 
	 void deleteReaderById(int id);
	 
}
