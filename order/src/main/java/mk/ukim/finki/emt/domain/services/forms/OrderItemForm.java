package mk.ukim.finki.emt.domain.services.forms;

import com.sun.istack.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.domain.valueobject.Product;

@Data
public class OrderItemForm {
    @NotNull
    private Product product;
    @NotNull
    private Integer quantity;
}