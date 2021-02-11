package org.icici.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "userdet")
public class Userdet {

	@Id
	@GeneratedValue(strategy=GenerationType.SEQUENCE, generator="course_seq")
	@SequenceGenerator(
	    name="course_seq",
	    sequenceName="course_sequence")
	private int id;

	private String username;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

}
