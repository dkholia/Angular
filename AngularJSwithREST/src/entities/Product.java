package entities;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement (name="Product")
public class Product {
	
	
	private String id;
	
	private String name;
	
	private int price;
	
	private int quantity;

	public Product() {
	}
	public  Product(String id,String name,int price,int quantity){
		this.id=id;
		this.name=name;
		this.price=price;
		this.quantity=quantity;
	}
	
	@XmlElement(name="id")
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	@XmlElement(name="name")
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	@XmlElement(name="price")
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	@XmlElement(name="quantity")
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
}
