package mk.ukim.finki.emt.domain.services;

import mk.ukim.finki.emt.domain.model.Order;
import mk.ukim.finki.emt.domain.model.OrderId;
import mk.ukim.finki.emt.domain.model.OrderItemId;
import mk.ukim.finki.emt.domain.services.forms.OrderForm;
import mk.ukim.finki.emt.domain.valueobject.Product;

import java.util.List;

public interface IOrderService {
    Order findById(OrderId id);

    OrderId placeOrder(OrderForm order);

    void cancelOrder(OrderId id);

    void addItem(OrderId id, Product product, Integer quantity);

    void removeItem(OrderId id, OrderItemId item);

    List<Order> listAll();
}
