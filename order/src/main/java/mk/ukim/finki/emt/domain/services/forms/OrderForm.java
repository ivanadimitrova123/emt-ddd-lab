package mk.ukim.finki.emt.domain.services.forms;


import com.sun.istack.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.domain.model.OrderState;
import mk.ukim.finki.emt.domain.model.OrderType;
import mk.ukim.finki.emt.domain.valueobject.User;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Currency;


import java.util.Set;

@Data
public class OrderForm {
    @NotNull
    private OrderState state;
    @NotNull
    private Currency currency;
    @NotNull
    private OrderType type;
    @NotNull
    private User user;
    private Set<OrderItemForm> items;
}