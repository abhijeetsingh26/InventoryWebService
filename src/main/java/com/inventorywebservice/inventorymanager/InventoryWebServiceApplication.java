package com.inventorywebservice.inventorymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@EnableAutoConfiguration
@SpringBootApplication(scanBasePackages={"com.inventorywebservice.inventorymanager"})
public class InventoryWebServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryWebServiceApplication.class, args);
	}
}
