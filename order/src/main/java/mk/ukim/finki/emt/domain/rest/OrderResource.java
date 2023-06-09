package mk.ukim.finki.emt.domain.rest;


import lombok.AllArgsConstructor;
import mk.ukim.finki.emt.domain.model.Order;
import mk.ukim.finki.emt.domain.model.OrderId;
import mk.ukim.finki.emt.domain.model.OrderItemId;
import mk.ukim.finki.emt.domain.services.IOrderService;
import mk.ukim.finki.emt.domain.services.forms.OrderForm;
import mk.ukim.finki.emt.domain.valueobject.Product;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/orders")
@AllArgsConstructor
public class OrderResource {
    private final IOrderService orderService;

    @GetMapping
    public List<Order> listAll() {
        return orderService.listAll();
    }

    @GetMapping("/{id}")
    public Order findById(@PathVariable OrderId id) {
        return orderService.findById(id);
    }

    @PostMapping("/place")
    public void placeOrder(@RequestBody OrderForm order, HttpServletResponse response) throws IOException {
        orderService.placeOrder(order);
        response.sendRedirect("/api/orders");
    }

    @PostMapping("/{id}/cancel")
    public void cancelOrder(@PathVariable OrderId id, HttpServletResponse response) throws IOException {
        orderService.cancelOrder(id);
        response.sendRedirect("/api/orders");
    }

    @PostMapping("/{id}/add")
    public void addItem(@PathVariable OrderId id, @RequestBody Product product, @RequestBody Integer quantity, HttpServletResponse response) throws IOException {
        orderService.addItem(id, product, quantity);
        response.sendRedirect("/api/orders");
    }

    @PostMapping("/{id}/remove")
    public void removeItem(@PathVariable OrderId id, @RequestBody OrderItemId item, HttpServletResponse response) throws IOException {
        orderService.removeItem(id, item);
        response.sendRedirect("/api/orders");
    }
}