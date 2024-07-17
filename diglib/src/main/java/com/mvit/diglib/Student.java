package com.mvit.diglib;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
	@Id
	@Column(name="SID")
	private int ID;
	@Column(name="Syear")
	private int year;
	@Column(name="Sname")
	private String name;
	@Column(name="Sbook")
	private String book;
	@Column(name="Bid")
	private int Bid;
	public int getBid() {
		return Bid;
	}
	public void setBid(int bid) {
		Bid = bid;
	}
	public Student(int iD, int year, String name, String book, int bid) {
		super();
		ID = iD;
		this.year = year;
		this.name = name;
		this.book = book;
		Bid = bid;
	}
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public Student(int iD, int year, String name, String book) {
		super();
		ID = iD;
		this.year = year;
		this.name = name;
		this.book = book;
	}
	public Student() {
		super();
		// TODO Auto-generated constructor stub
	}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@Override
	public String toString() {
		return "Student [ID=" + ID + ", year=" + year + ", name=" + name + ", book=" + book + ", Bid=" + Bid + "]";
	}
}
