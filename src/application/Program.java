package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Client;
import entities.Order;
import entities.OrderItem;
import entities.Product;
import entities.enums.OrderStatus;

public class Program {

	public static void main(String[] args) throws ParseException {
		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);
		
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		SimpleDateFormat sdf2 = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

		System.out.println("Enter client data:");
		System.out.print("Name: ");
		String clientName = sc.nextLine();
		System.out.print("Email: ");
		String clientEmail = sc.nextLine();
		System.out.print("Birth date (DD/MM/YYYY): ");
		String data = sc.nextLine();
		
		Client client = new Client(clientName,clientEmail,sdf.parse(data));
		
		System.out.println("Enter order data: ");
		
		System.out.print("Status: ");
		String status = sc.nextLine();
		OrderStatus os1 = OrderStatus.valueOf(status);
		
		Order order = new Order(client.getBirthDate(), os1);

		
		System.out.print("How many items to this order? ");
		int n = sc.nextInt();
		sc.nextLine();
		
		Product product = new Product();
		
		for (int i = 0; i < n; i++) {
			System.out.print("Enter #"+i+1+" item data: ");
			System.out.print("Product name: ");
			product.setName(sc.nextLine());			
			System.out.print("Product price: ");
			product.setPrice(sc.nextDouble());
			System.out.print("Quantity: ");
			int quantity = sc.nextInt();
			sc.nextLine();
			
			OrderItem item = new OrderItem(quantity, product.getPrice(), product);
			item.setPrice(item.subTotal());
			
			order.addItem(item);
			
		}
		
		System.out.println();
		System.out.println("ORDER SUMMARY:");
		System.out.println("Order moment: "+ sdf2.format(new Date()));
		System.out.println("Order Status: "+os1);
		System.out.println(client.toString());
		System.out.println("order items: ");
		System.out.println(order.toString());
		
		sc.close();
	}

}
