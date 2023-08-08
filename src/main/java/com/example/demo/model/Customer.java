package com.example.demo.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Entity
@Table(name="customer")

public class Customer {
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	private long id;

    @NotBlank (message = "Title cannot be blank")
	@Column(name="title")

	private String title;

	@Column(name="description")
	private String description;

    @NotNull (message = "Date cannot be blank")
	@Column(name = "date")
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate date;


	@Column(name = "completed")
	private boolean completed;

//	public boolean isNotcompleted() {
//		return notcompleted;
//	}
//
//	public void setNotcompleted(boolean notcompleted) {
//		this.notcompleted = notcompleted;
//	}

//	@Column(unique = false)
//	private boolean notcompleted;

	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}


	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}



}
