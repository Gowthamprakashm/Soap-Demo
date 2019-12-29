package com.soap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.soap.calculator.Add;
import com.soap.calculator.AddResponse;
import com.soap.client.SoapClient;

@SpringBootApplication
@RestController
public class PocApplication {
	
	
	@Autowired
	private SoapClient client;
	
	
	@PostMapping("/soap")
	public AddResponse response(@RequestBody Add req) {
		return client.soapConsumer(req);
	}

	public static void main(String[] args) {
		SpringApplication.run(PocApplication.class, args);
	}

}
