package com.example.SpringPassoAPasso.entities;

import java.io.Serializable;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;

import com.example.SpringPassoAPasso.entities.pk.OrderItemPk;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "Tb_Itens")
public class OrderItem implements Serializable{
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private OrderItemPk id = new OrderItemPk();

	private Double price;
	private Integer quantity;

	public OrderItem() {

	}

	public OrderItem(Order order, Product product, Double price, Integer quantity) {
		super();
		id.setOrder(order);
		id.setProduct(product);
		this.price = price;
		this.quantity = quantity;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	@JsonIgnore
	public Order getOrder() {
		return id.getOrder();
	}

	public void setOrder(Order order) {
		id.setOrder(order);
	}

	public Product getProduct() {
		return id.getProduct();
	}

	public void setProduct(Product product) {
		id.setProduct(product);
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		OrderItem other = (OrderItem) obj;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
