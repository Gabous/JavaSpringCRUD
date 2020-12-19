package com.gabriel.springcrud.springboot.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "stocks")
public class Stocks {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	
	@Column(nullable = false, length = 10, name = "name")
	private String name;
	
	@Column(name = "quotes")
	private String quotes;
	
	
	@Override
	public String toString() {
		return "Stock [id ="
			+ id + ", name="
			+ name + ", quotes="
			+ quotes + "]";
	}
	
	public Stocks() {
		
	}
	
	public Stocks(String name, String quotes) {
		super();
		this.name = name;
		this.quotes = quotes;
	}
	
	public long getId() {
		return id;
	}
	
	
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getQuotes() {
		return quotes;
	}
	public void setQuotes(String quotes) {
		this.quotes = quotes;
	}
	
	
}
