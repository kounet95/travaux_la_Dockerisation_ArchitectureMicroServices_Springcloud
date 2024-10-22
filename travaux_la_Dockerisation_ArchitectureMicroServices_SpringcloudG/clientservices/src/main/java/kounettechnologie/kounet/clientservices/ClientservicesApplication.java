package kounettechnologie.kounet.clientservices;

//import kounettechnologie.kounet.clientservices.config.GlobalConfig;
import kounettechnologie.kounet.clientservices.config.GlobalConfig;
import kounettechnologie.kounet.clientservices.entities.Customer;
import kounettechnologie.kounet.clientservices.repository.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
@EnableConfigurationProperties({GlobalConfig.class})
public class ClientservicesApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientservicesApplication.class, args);
    }
    @Bean
    CommandLineRunner commandLineRunner(CustomerRepository customerRepository){
        return args -> {

            List<Customer> customerList=List.of(
                    Customer.builder()
                            .firstName("oumar")
                            .lastName("diallo")
                            .email("kounet@gmail.com")
                            .build(),
                    Customer.builder()
                            .firstName("alpha")
                            .lastName("bayo")
                            .email("dillo@gmail.com")
                            .build()

            );
            customerRepository.saveAll(customerList);
        };
    }
}
