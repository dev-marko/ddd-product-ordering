package mk.ukim.finki.emt.ordermanagement.services.forms;

import lombok.Getter;
import lombok.Setter;
import mk.ukim.finki.emt.sharedkernel.domain.financial.enumerations.Currency;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class OrderForm {

    @NotNull
    private Currency currency;

    @Valid
    @NotEmpty
    private List<OrderItemForm> items = new ArrayList<>();
}
