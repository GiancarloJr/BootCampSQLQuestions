package com.devsuperior.uri2602;

import ch.qos.logback.core.net.SyslogOutputStream;
import com.devsuperior.uri2602.dto.CustomerMinDTO;
import com.devsuperior.uri2602.entities.Customer;
import com.devsuperior.uri2602.projections.CustomerNameProjections;
import com.devsuperior.uri2602.repositories.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;
import java.util.stream.Collectors;

@SpringBootApplication
public class Uri2602Application implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(Uri2602Application.class, args);
	}

	@Autowired
	CustomerRepository customerRepository;

	@Override
	public void run(String... args) throws Exception {

		List<CustomerNameProjections> list = customerRepository.search1("rs");
		List<CustomerMinDTO> result1 = list.stream().map(x -> new CustomerMinDTO(x)).collect(Collectors.toList());
		List<CustomerMinDTO> result2 = customerRepository.search2("rs");

		//BUSCA COM SQL RAIZ
		for(CustomerMinDTO obj : result1) {
			System.out.println(obj.toString());
		}
		//BUSCA COM JPQL
		for(CustomerMinDTO obj : result2) {
			System.out.println(obj.toString());
		}
	}
}
