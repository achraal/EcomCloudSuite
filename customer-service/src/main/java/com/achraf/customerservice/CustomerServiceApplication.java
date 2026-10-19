package com.achraf.customerservice;

import com.achraf.customerservice.entities.Customer;
import com.achraf.customerservice.repository.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;

@SpringBootApplication
public class CustomerServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CustomerServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {
            customerRepository.save(Customer.builder()
                    .name("achraf")
                    .email("achraf@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("ahmed")
                    .email("ahmed@gmail.com")
                    .build());
            customerRepository.save(Customer.builder()
                    .name("mohamed")
                    .email("mohamed@gmail.com")
                    .build());
            customerRepository.findAll().forEach(c -> {
                System.out.println("============");
                System.out.println(c.getId());
                System.out.println(c.getName());
                System.out.println(c.getEmail());
                System.out.println("============");
            });
        };
    }

}
