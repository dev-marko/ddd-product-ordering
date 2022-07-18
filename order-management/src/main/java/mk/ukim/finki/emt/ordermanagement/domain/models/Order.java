package mk.ukim.finki.emt.ordermanagement.domain.models;

import org.springframework.lang.NonNull;
import mk.ukim.finki.emt.ordermanagement.domain.enumerations.OrderState;
import mk.ukim.finki.emt.ordermanagement.domain.valueobjects.Product;
import mk.ukim.finki.emt.sharedkernel.domain.base.AbstractEntity;
import mk.ukim.finki.emt.sharedkernel.domain.financial.Money;
import mk.ukim.finki.emt.sharedkernel.domain.financial.enumerations.Currency;

import javax.persistence.*;
import java.time.Instant;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "orders")
public class Order extends AbstractEntity<OrderId> {

    private Instant orderedOn;

    @Enumerated(value = EnumType.STRING)
    private OrderState orderState;

    @Column(name = "order_currency")
    @Enumerated(value = EnumType.STRING)
    private Currency currency;

    @OneToMany(
            cascade = CascadeType.ALL,
            orphanRemoval = true,
            fetch = FetchType.EAGER)
    private Set<OrderItem> orderItemList;

    private Order() {
        super(OrderId.randomId(OrderId.class));
    }

    public Order(Instant orderedOn, @NonNull Currency currency) {
        super(OrderId.randomId(OrderId.class));
        this.orderedOn = orderedOn;
        this.currency = currency;
    }

    public Money total() {
        return orderItemList
                .stream()
                .map(OrderItem::subTotal)
                .reduce(new Money(currency, 0.0), Money::add);
    }

    public OrderItem addItem(@NonNull Product product, @NonNull Integer quantity) {
        Objects.requireNonNull(product, "product must not be null");
        var item = new OrderItem(product.getId(), product.getPrice(), quantity);
        orderItemList.add(item);
        return item;
    }

    public void removeItem(@NonNull OrderItemId orderItemId) {
        Objects.requireNonNull(orderItemId, "Order Item Id must not be null");
        orderItemList.removeIf(i -> i.getId().equals(orderItemId));
    }
}
