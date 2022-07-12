package mk.ukim.finki.emt.ordermanagement.domain.models;

import lombok.NoArgsConstructor;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.ProductId;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;

import javax.persistence.AttributeOverride;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "order_item")
@NoArgsConstructor
public class OrderItem extends AbstractEntity<OrderItemId> {


    private Money itemPrice;

    @Column(nullable = false)
    private Integer quantity;

    @AttributeOverride(name = "id", column = @Column(name = "product_id", nullable = false))
    private ProductId productId;
}
