package pl.postek.final_shop.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import pl.postek.final_shop.model.entity.Customer;
import pl.postek.final_shop.model.entity.Order;
import pl.postek.final_shop.service.OrderService;

@Controller
public class OrderController {
    private static final Logger logger = LoggerFactory.getLogger(OrderController.class);
    private OrderService service;

    public OrderController(OrderService service) {
        this.service = service;
    }

    @GetMapping("/current-order")
    public String orderForm(Customer customer, Order order) {
        service.form(order, customer);
        logger.info("orderForm with customerId [{}] and orderId [{}]", customer.getId(), order.getOrderId());
        return "order/order-form";
    }

    @PostMapping
    public String processOrder(Order order, Customer customer) {
        logger.info("order is processing...");
        order.setCustomer(customer);
        service.save(order);
        return "redirect:/";
    }
}
