package mk.ukim.finki.emt.ordermanagement.domain.valueobjects;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.sharedkernel.domain.financial.enumerations.Currency;

@Getter
public class Product implements ValueObject {

    private final ProductId id;
    private final String name;
    private final Money price;
    private final Integer sales;

    private Product() {
        this.id = ProductId.randomId(ProductId.class);
        this.name= "";
        this.price = Money.valueOf(Currency.MKD,0.0);
        this.sales = 0;
    }

    @JsonCreator
    public Product(@JsonProperty("id") ProductId id,
                   @JsonProperty("productName") String name,
                   @JsonProperty("price") Money price,
                   @JsonProperty("sales") Integer sales) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.sales = sales;
    }
}
