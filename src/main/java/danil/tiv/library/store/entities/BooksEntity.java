package danil.tiv.library.store.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "books")
public class BooksEntity {

	  @Id
	  @GeneratedValue(strategy = GenerationType.IDENTITY)
	  @Column(name = "book_id")
	  private int bookId;
	
	  
	  @Column(name = "book_name")
	  private String bookName;
	  
	  @Column(name = "author")
	  private String author;
	  
	  @Column(name = "year_of_book")
	  private LocalDate yearBook;
	  
	  @Column(name = "count_of_book")
	  private int countBook;
	  
	  public BooksEntity() {}
	  
	  public BooksEntity(int bookId, String bookName, String author, LocalDate yearBook, int countBook) {
		  this.bookId = bookId;
		  this.bookName = bookName;
		  this.author = author;
		  this.yearBook = yearBook;
		  this.countBook = countBook;
	  }
	  
	  public int getBookId() {
		 return bookId;
	  }
	  
	  public void setBookId(int bookId) {
		  this.bookId = bookId;
	  }
	  

	  public String getBookName() {
		  return bookName;
	  }
		  
	  public void setBookName(String bookName ) {
		  if (bookName == null) {
		        throw new IllegalArgumentException("Book Name cannot be null");
		  }
		  this.bookName = bookName;
	  }
	  
	  public String getAuthor() {
		  return author;
	  }
		  
	  public void setAuthor(String author) {
		  if (author == null) {
		        throw new IllegalArgumentException("Author cannot be null");
		  }
		  this.author = author;
	  }
	  
	  public LocalDate getYearBook() {
		  return yearBook;
	  }
		  
	  public void setYearBook(LocalDate yearBook) {
		  if(yearBook == null) {
			  throw new IllegalArgumentException("Year of Book cannot be null");
		  }
		  this.yearBook = yearBook;
	  }
	  
	  public int getCountBook() {
		  return countBook;
	  }
	  
	  public void setCountBook(int countBook) {
		  if(countBook < 0) {
			  throw new IllegalArgumentException("Count of books cannot be less than 0");
		  }
		  this.countBook = countBook;
	  }
	  
	  
}