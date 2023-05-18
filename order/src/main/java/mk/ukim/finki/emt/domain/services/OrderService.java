package mk.ukim.finki.emt.domain.services;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import mk.ukim.finki.emt.domain.exeption.OrderNotFound;
import mk.ukim.finki.emt.domain.model.Order;
import mk.ukim.finki.emt.domain.model.OrderId;
import mk.ukim.finki.emt.domain.model.OrderItemId;
import mk.ukim.finki.emt.domain.model.OrderState;
import mk.ukim.finki.emt.domain.repository.OrderRepository;
import mk.ukim.finki.emt.domain.services.forms.OrderForm;
import mk.ukim.finki.emt.domain.valueobject.Product;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.time.Instant;
import java.util.List;

@Service
@Transactional
@AllArgsConstructor
public class OrderService implements IOrderService {
    private final OrderRepository orderRepository;

    @Override
    public Order findById(@NonNull OrderId id) {
        return orderRepository.findById(id).orElseThrow(() -> new OrderNotFound(id.getId()));
    }

    @Override
    public OrderId placeOrder(@NonNull OrderForm order) {
        var o = new Order(Instant.now(), order.getState(), order.getCurrency(), order.getType(), order.getUser());
        return o.getId();
    }

    @Override
    public void cancelOrder(@NonNull OrderId id) {
        var order = findById(id);

        order.changeState(OrderState.FAILED);

        orderRepository.saveAndFlush(order);
    }

    @Override
    public void addItem(@NonNull OrderId id, @NonNull Product product, @NonNull Integer quantity) {
        var order = findById(id);

        order.addItem(product, quantity);

        orderRepository.saveAndFlush(order);
    }

    @Override
    public void removeItem(@NonNull OrderId id, @NonNull OrderItemId item) {
        var order = findById(id);

        order.removeItem(item);

        orderRepository.saveAndFlush(order);
    }

    @Override
    public List<Order> listAll() {
        return orderRepository.findAll();
    }
}
