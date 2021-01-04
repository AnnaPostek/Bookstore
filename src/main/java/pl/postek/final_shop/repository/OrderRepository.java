package pl.postek.final_shop.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.postek.final_shop.model.entity.Order;

@Repository
public interface OrderRepository extends JpaRepository<Order, String> {
}
