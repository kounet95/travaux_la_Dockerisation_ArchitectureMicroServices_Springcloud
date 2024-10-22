package kounettechnologie.kounet.clientservices.repository;


import kounettechnologie.kounet.clientservices.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
