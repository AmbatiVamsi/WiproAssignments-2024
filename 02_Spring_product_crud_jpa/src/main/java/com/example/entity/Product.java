package com.example.entity;



import org.antlr.v4.runtime.misc.NotNull;
//import javax.validation.constraints.NotNull;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "Product")
public class Product {
	
	private int id;  
	@NotNull
	private String pname;   
	private double price;
	
	public Product() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Product(int id, String pname, double price) {
		super();
		this.id = id;
		this.pname = pname;
		this.price = price;
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
	public int getId() {
		return id;
	}
	
	
	public void setId(int id) {
		this.id = id;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	@Column(name = "pname", nullable = false)
	public String getPname() {
		return pname;
	}
	
	
	@Column(name = "price", nullable = false)
	
	public double getPrice() {
		return price;
	}
	 
}
