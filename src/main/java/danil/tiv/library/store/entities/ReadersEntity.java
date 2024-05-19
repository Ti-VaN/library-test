package danil.tiv.library.store.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "readers")
public class ReadersEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "reader_id")
	private int readerId;
	
	@Column(name = "full_name", nullable = false)	
	private String fullName;
	
	@Column(name = "gender", nullable = false)
	private Gender gender;
	
	@Column(name = "age", nullable = false)
	private int age;
	
	public ReadersEntity() {}
	
	public ReadersEntity(int readerId, String fullName, Gender gender, int age) {
		this.readerId = readerId;
		this.fullName = fullName;
		this.gender = gender;
		this.age = age;
	}
	
	public int getReaderId() {
		return readerId;
	}
	
	public void setReaderId(int readerId) {
		this.readerId = readerId;
	}
	
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		if (fullName == null) {
	        throw new IllegalArgumentException("Full name cannot be null");
	  }
		this.fullName = fullName;
	}
	
	public Gender getGender() {
		return gender;
	}
	
	@Enumerated(EnumType.STRING)
	public void setGender(Gender gender) {
		this.gender = gender;
	}
	
	public int getAge() {
		return age;
	}
	
	public void setAge(int age) {
		if (age < 0 || age > 150) {
	        throw new IllegalArgumentException("Homosapiens can't be that old");
	  }
		this.age = age;
	}

}

enum Gender{
	MALE,
	FEMALE	
}
