package mk.ukim.finki.emt.domain.repository;

import mk.ukim.finki.emt.domain.model.Order;
import mk.ukim.finki.emt.domain.model.OrderId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, OrderId> {
}
