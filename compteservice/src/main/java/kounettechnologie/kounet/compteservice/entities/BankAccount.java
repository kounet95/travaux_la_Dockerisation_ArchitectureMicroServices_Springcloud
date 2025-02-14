package kounettechnologie.kounet.compteservice.entities;

import jakarta.persistence.*;
import kounettechnologie.kounet.compteservice.enums.AccountType;
import kounettechnologie.kounet.compteservice.model.Customer;
import lombok.*;


import java.time.LocalDate;
@Entity
@Getter @Setter @ToString @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
    @Id
    private String accountId;
    private double balance;
    private LocalDate createAt;
    private String currency;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    @Transient
    private Customer customer;
    private Long customerId;
}
