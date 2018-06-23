package com.nitheesh;

import com.nitheesh.mvc.primary.domain.Person;
import com.nitheesh.mvc.primary.repository.PersonRepository;
import com.nitheesh.mvc.secondary.domain.Details;
import com.nitheesh.mvc.secondary.repository.DetailsRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.stream.Stream;

@SpringBootApplication
@ComponentScan(basePackages = "com.nitheesh")
public class MysqlMultiDbConfigApplication {

    public static void main(String[] args) {
        SpringApplication.run(MysqlMultiDbConfigApplication.class, args);
    }

    @Bean
    CommandLineRunner adminCourse(PersonRepository personRepository, DetailsRepository detailsRepository) {


        return args -> {
            personRepository
                    .deleteAll();

            Stream.of(new Person("Nitheesh Chandran", "Ernakulam"),
                    new Person("Lionel Messi", "Argentina"),
                    new Person("Andreas Inniesta", "Argentina"),
                    new Person("David Villa", "Argentina"))
                    .forEach(course -> {
                        personRepository.save(course);

                    });

            detailsRepository.deleteAll();

            Stream.of(new Details("Software Engineer"),
                    new Details("Footballer"),
                    new Details("Footballer"),
                    new Details("Footballer"))
                    .forEach(course -> {
                        detailsRepository.save(course);

                    });
        };

    }
}
