package com.soap.client;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.stereotype.Service;
import org.springframework.ws.client.core.WebServiceTemplate;

import com.soap.calculator.Add;
import com.soap.calculator.AddResponse;

@Service
public class SoapClient {

	@Autowired
	private Jaxb2Marshaller marshaller;

	private WebServiceTemplate template;

	public AddResponse soapConsumer(Add request) {
		template = new WebServiceTemplate(marshaller);
		AddResponse response = (AddResponse) template
				.marshalSendAndReceive("http://DESKTOP-TCBOD4A:8088/mockCalculatorSoap", request);
		return response;
	}

}
