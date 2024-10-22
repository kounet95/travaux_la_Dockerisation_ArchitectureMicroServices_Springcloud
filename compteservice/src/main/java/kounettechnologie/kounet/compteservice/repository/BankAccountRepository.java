package kounettechnologie.kounet.compteservice.repository;


import kounettechnologie.kounet.compteservice.entities.BankAccount;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankAccountRepository extends JpaRepository<BankAccount, String> {
}
