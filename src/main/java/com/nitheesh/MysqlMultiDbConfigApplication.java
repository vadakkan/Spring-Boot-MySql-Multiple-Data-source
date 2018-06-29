package com.nitheesh;

import com.nitheesh.mvc.primary.domain.Address;
import com.nitheesh.mvc.primary.domain.Person;
import com.nitheesh.mvc.primary.repository.AddressRepository;
import com.nitheesh.mvc.primary.repository.PersonRepository;
import com.nitheesh.mvc.secondary.repository.DetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
@ComponentScan(basePackages = "com.nitheesh")
public class MysqlMultiDbConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlMultiDbConfigApplication.class, args);
    }

    @Bean
    CommandLineRunner adminCourse(PersonRepository personRepository, AddressRepository addressRepository) {


        return args -> {

            personRepository
                    .deleteAll();
            addressRepository.deleteAll();


            List<Address> addressList=new ArrayList<>();
            addressList.add(addressRepository.save(new Address().defaultAddressOne()));
            addressList.add(addressRepository.save(new Address().defaultAddressTwo()));

            personRepository.save(new Person(addressList));


        };

    }
}
