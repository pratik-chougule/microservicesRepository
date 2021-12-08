package com.lti;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.actuate.info.Info.Builder;
import org.springframework.boot.actuate.info.InfoContributor;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;

@SpringBootApplication
@EnableDiscoveryClient
@EnableHystrix
@EnableCircuitBreaker
public class CustomerProducerServiceApplication implements InfoContributor {

	public static void main(String[] args) {
		SpringApplication.run(CustomerProducerServiceApplication.class, args);
	}

	@Override
	public void contribute(Builder builder) {
		builder.withDetail("details",
				Collections.singletonMap("description", "This is the Bank service, which is discovery server aware,and this service will Call Customer Microservice, from customer details, which is again dicovery server aware!!! "));
				 

		
	}

}
