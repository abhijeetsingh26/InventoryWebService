package com.inventorywebservice.inventorymanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages={"com.inventorywebservice.inventorymanager"})
public class InventoryWebServiceApplication {

	public static void main(String[] args) {
		System.out.println(">>>>>>>>>>>>>>>> HERE");
		SpringApplication.run(InventoryWebServiceApplication.class, args);
	}
}
