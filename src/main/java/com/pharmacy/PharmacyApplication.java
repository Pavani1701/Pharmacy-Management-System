package com.pharmacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PharmacyApplication {

	public static void main(String[] args) throws Exception {
		SpringApplication.run(PharmacyApplication.class, args);
		System.out.println("Pharmacy Application Started!!!");
		Runtime.getRuntime().exec("cmd /c start chrome.exe http://localhost:8001");
	}

}
