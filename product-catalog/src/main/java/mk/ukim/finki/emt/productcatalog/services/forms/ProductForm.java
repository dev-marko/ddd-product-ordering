package mk.ukim.finki.emt.productcatalog.services.forms;

import lombok.Getter;
import lombok.Setter;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.validation.constraints.NotNull;

@Getter
@Setter
public class ProductForm {

    @NotNull
    private String productName;

    @NotNull
    private Money price;

    private Integer sales;
}
