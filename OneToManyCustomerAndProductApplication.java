package com.example;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.model.Customer;
import com.example.model.Product;
import com.example.repository.CustomerRepository;
import com.example.repository.ProductRepository;

@SpringBootApplication
public class OneToManyCustomerAndProductApplication implements CommandLineRunner {
	@Autowired
private CustomerRepository customerRepository;
	@Autowired
	private ProductRepository productrepository;
	public static void main(String[] args) {
		SpringApplication.run(OneToManyCustomerAndProductApplication.class, args);
	}
	@Override
	public void run(String... args) throws Exception {
		// TODO Auto-generated method stub
		
		Customer customer=new Customer("Abhishek Wagh");
		Customer customer1=new Customer("Vikram Sonawane");
		
		Product facewash=new Product("Garnier Men",customer);
		Product suncream=new Product("Nivia",customer);
		Product mobilephone=new Product("Iphone 14", customer1);
		Product laptop=new Product("Lenevo tuf gaming", customer1);
		
		List<Product> product=Arrays.asList(facewash,suncream);
		List<Product> product1=Arrays.asList(mobilephone,laptop);
		
		customer.setProduct(product);
		customer1.setProduct(product1);
		
		customerRepository.save(customer);
		customerRepository.save(customer1);
	}
}