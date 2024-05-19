package danil.tiv.library.store.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "state_of_book")
public class StateOfBooksEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "state_of_book_id")
	private int stateOfBooksId;
	
	@Column(name = "reader_id", nullable = false)
	private int readerId;
	
	@Column(name = "book_id", nullable = false)
	private int bookId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "state_of_book", nullable = false)
	private State stateOfBook;
	
	@Column(name = "date_state_of_book", nullable = false)
	private LocalDate dateStateOfBook;
	
	public StateOfBooksEntity() {}
	
	public StateOfBooksEntity(int stateOfBooksId, int readerId, int bookId, State stateOfBook, LocalDate dateStateOfBook) {
		this.stateOfBooksId = stateOfBooksId;
		this.readerId =  readerId;
		this.bookId = bookId;	
		this.stateOfBook = stateOfBook;
		this.dateStateOfBook = dateStateOfBook;
	}
	
	public int getStateOfBooksId() {
		return stateOfBooksId;
	}
	
	public void setStateOfBooksId(int stateOfBooksId) {
		this.stateOfBooksId = stateOfBooksId;
	}
	
	public int getReaderId() {
		return readerId;
	}
	
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	
	public int getBookId() {
		return bookId;
	}

	public void setBookId(int bookId) {
		this.bookId = bookId;
	}
	
	public State getStateOfBook() {
		return stateOfBook;
	}
	
	public void setStateOfBook(State stateOfBook) {
		 if(stateOfBook == null) {
			  throw new IllegalArgumentException("State of Book cannot be null");
		  }
		this.stateOfBook = stateOfBook;
	}
		
	public LocalDate getDateStateOfBook() {
		return dateStateOfBook;
	}
	
	public void setDateStateOfBook(LocalDate dateStateOfBook) {
		  if(dateStateOfBook == null) {
			  throw new IllegalArgumentException("Date state of Book cannot be null");
		  }
		this.dateStateOfBook = dateStateOfBook;
	}

}

enum State{
	ISSUANCE,
	DELIVERY,
	INPLACE
}