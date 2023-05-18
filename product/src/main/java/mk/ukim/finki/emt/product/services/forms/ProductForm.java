package mk.ukim.finki.emt.product.services.forms;

import com.sun.istack.NotNull;
import lombok.Data;
import mk.ukim.finki.emt.product.domain.valueObjects.Quantity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

@Data
public class ProductForm {
    @NotNull
    private String name;
    @NotNull
    private Quantity quantity;
    @NotNull
    private Money price;
}