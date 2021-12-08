package com.lti.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@Service
public class CustomerServiceDelegate {
	
	@Autowired
	RestTemplate restTemplate;
	@HystrixCommand(fallbackMethod = "callCustomerServiceAndGetData_Fallback")
	public String callCustomerServiceAndGetData(String name) {
		System.out.println("Getting Customer details for " +name);
		String response = restTemplate
				.exchange("http://localhost:8092/bank-api/**"
				, HttpMethod.GET
				, null
				, new ParameterizedTypeReference<String>() {
			}, name).getBody();
		System.out.println("Response Received as " + response + " -  " + new Date());
		return "NORMAL FLOW !!! - Customer Name -  " + name + " :::  Customer Details " + response + " -  " + new Date();
	}
	@SuppressWarnings("unused")
	private String callCustomerServiceAndGetData_Fallback(String name) {
		System.out.println("Customer Service is down!!! fallback route enabled...");
		return "CIRCUIT BREAKER ENABLED!!!No Response From Customer Service at this moment. Service will be back shortly - " + new Date();
	}
	@Bean
	public RestTemplate restTemplate() {
		return new RestTemplate();
	}
	

}
