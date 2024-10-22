package kounettechnologie.kounet.compteservice;

import kounettechnologie.kounet.compteservice.clients.CustomerRestClient;
import kounettechnologie.kounet.compteservice.entities.BankAccount;
import kounettechnologie.kounet.compteservice.enums.AccountType;
import kounettechnologie.kounet.compteservice.repository.BankAccountRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.time.LocalDate;
import java.util.UUID;

@SpringBootApplication
@EnableFeignClients
public class CompteserviceApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompteserviceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BankAccountRepository accountRepository, CustomerRestClient customerRestClient) {
        return args -> {
            customerRestClient.allCustomers().forEach(c -> {
                BankAccount bankAccount1 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("kounet")
                        .balance(Math.random() * 80000)
                        .createAt(LocalDate.now())
                        .type(AccountType.CURRENT_ACCOUNT)
                        .customerId(c.getId())
                        .build();
                BankAccount bankAccount2 = BankAccount.builder()
                        .accountId(UUID.randomUUID().toString())
                        .currency("diallo")
                        .balance(Math.random() * 65432)
                        .createAt(LocalDate.now())
                        .type(AccountType.SAVING_ACCOUNT)
                        .customerId(c.getId())
                        .build();
                accountRepository.save(bankAccount1);
                accountRepository.save(bankAccount2);
            });


        };
    }
}
