package pl.postek.final_shop.service;

import org.springframework.stereotype.Service;
import pl.postek.final_shop.model.entity.Customer;
import pl.postek.final_shop.model.entity.Order;
import pl.postek.final_shop.repository.OrderRepository;

@Service
public class OrderService {
    private OrderRepository repository;

    public OrderService(OrderRepository repository) {
        this.repository = repository;
    }

    public Order form(Order order, Customer customer) {
        if (order.getDeliveryName() == null) {
            order.setDeliveryName(customer.getFullName());
        }
        if (order.getDeliveryStreet() == null) {
            order.setDeliveryStreet(customer.getStreet());
        }
        if (order.getDeliveryCity() == null) {
            order.setDeliveryCity(customer.getCity());
        }
        if (order.getDeliveryZip() == null) {
            order.setDeliveryZip(customer.getZip());
        }
        return order;
    }
}
