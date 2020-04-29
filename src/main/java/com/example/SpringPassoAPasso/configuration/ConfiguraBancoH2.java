package com.example.SpringPassoAPasso.configuration;

import java.time.Instant;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import com.example.SpringPassoAPasso.entities.Category;
import com.example.SpringPassoAPasso.entities.Order;
import com.example.SpringPassoAPasso.entities.OrderItem;
import com.example.SpringPassoAPasso.entities.Product;
import com.example.SpringPassoAPasso.entities.User;
import com.example.SpringPassoAPasso.entities.enumns.OrderStatus;
import com.example.SpringPassoAPasso.repositories.CategoryRepository;
import com.example.SpringPassoAPasso.repositories.OrderItemRepository;
import com.example.SpringPassoAPasso.repositories.OrderRepository;
import com.example.SpringPassoAPasso.repositories.ProductRepository;
import com.example.SpringPassoAPasso.repositories.UserRepository;

@Configuration
@Profile("test")
public class ConfiguraBancoH2 implements CommandLineRunner {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private OrderItemRepository OrderItemRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private CategoryRepository categoryRepository;

	@Autowired
	private ProductRepository productRepository;

	@Override
	public void run(String... args) throws Exception {

		// -------------------populando categorias---------------------

		Category cat1 = new Category(null, "Electronics");
		Category cat2 = new Category(null, "Books");
		Category cat3 = new Category(null, "Computers");

		categoryRepository.saveAll(Arrays.asList(cat1, cat2, cat3));
		// -------------------populando produtos---------------------

		Product p1 = new Product(null, "The Lord of the Rings", "Lorem ipsum dolor sit amet, consectetur.", 90.5, "");
		Product p2 = new Product(null, "Smart TV", "Nulla eu imperdiet purus. Maecenas ante.", 2190.0, "");
		Product p3 = new Product(null, "Macbook Pro", "Nam eleifend maximus tortor, at mollis.", 1250.0, "");
		Product p4 = new Product(null, "PC Gamer", "Donec aliquet odio ac rhoncus cursus.", 1200.0, "");
		Product p5 = new Product(null, "Rails for Dummies", "Cras fringilla convallis sem vel faucibus.", 100.99, "");

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		// ----Fazendo a associação de um produto com uma categoria

		p1.addCategories(cat2);
		p2.addCategories(cat1);
		p2.addCategories(cat3);
		p3.addCategories(cat3);
		p4.addCategories(cat3);
		p5.addCategories(cat2);

		productRepository.saveAll(Arrays.asList(p1, p2, p3, p4, p5));

		// -------------------populando usuarios---------------------

		User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
		User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

		userRepository.saveAll(Arrays.asList(u1, u2));

		// -------------------populando pedidos---------------------

		Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
		Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAYMENT, u2);
		Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.DELIVERED, u1);

		orderRepository.saveAll(Arrays.asList(o1, o2, o3));

		OrderItem oi1 = new OrderItem(o1, p1, p1.getPrice(), 2);
		OrderItem oi2 = new OrderItem(o1, p3, p1.getPrice(), 1);
		OrderItem oi3 = new OrderItem(o2, p3, p1.getPrice(), 2);
		OrderItem oi4 = new OrderItem(o3, p5, p1.getPrice(), 2);

		OrderItemRepository.saveAll(Arrays.asList(oi1, oi2, oi3, oi4));

	}

}
