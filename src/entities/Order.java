package entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import entities.enums.OrderStatus;

public class Order {

	private Date moment;
	private OrderStatus status;
	private List<OrderItem> items = new ArrayList<>();

	public Order() {
	}

	public Order(Date moment, OrderStatus status) {
		this.moment = moment;
		this.status = status;
	}

	public Date getMoment() {
		return moment;
	}

	public void setMoment(Date moment) {
		this.moment = moment;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public void setStatus(OrderStatus status) {
		this.status = status;
	}

	public List<OrderItem> getItem() {
		return items;
	}
	
	public void addItem(OrderItem item) {
		items.add(item);
	}
	
	public void removeItem(OrderItem item) {
		items.remove(item);
	}
	
	public Double total() {
		double sum = 0;
		for (OrderItem c: items) {
			sum+=c.getPrice();
		}
		return sum;
	}
	
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (OrderItem orderItem : items) {
			sb.append(orderItem.getProduct().getName()+", ");
			sb.append(orderItem.getProduct().getPrice()+",");
			sb.append("Quantity: "+orderItem.getQuantity()+", ");
			sb.append("Subtotal: $"+orderItem.getPrice()+", ");
		}
		System.out.println("Total price: $"+total());
		return sb.toString();
	}
	
}
