package pl.postek.final_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.postek.final_shop.model.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, String> {

    Customer findByFullName(String fullName);
}
