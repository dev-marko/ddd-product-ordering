package mk.ukim.finki.emt.ordermanagement.services.forms;

import com.sun.istack.NotNull;
import lombok.Getter;
import lombok.Setter;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Product;

import javax.validation.constraints.Min;

@Getter
@Setter
public class OrderItemForm {

    @NotNull
    private Product product;

    @Min(1)
    private Integer quantity = 1;
}
