package mk.ukim.finki.emt.sharedkernel.domain.financial;

import lombok.Getter;
import lombok.NonNull;
import mk.ukim.finki.emt.sharedkernel.domain.base.ValueObject;
import mk.ukim.finki.emt.sharedkernel.domain.financial.enumerations.Currency;

import javax.persistence.Embeddable;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.Objects;

@Embeddable
@Getter
public class Money implements ValueObject {

    @Enumerated(value = EnumType.STRING)
    private final Currency currency;
    private final Double amount;

    protected Money() {
        this.currency = null;
        this.amount = 0.0;
    }

    public Money(@NonNull Currency currency, @NonNull Double amount) {
        this.currency = currency;
        this.amount = amount;
    }

    public static Money valueOf(Currency currency, Double amount) {
        return new Money(currency, amount);
    }

    public Money add(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Cannot add two Money objects with different currencies");
        }
        return new Money(currency, amount + money.amount);
    }

    public Money subtract(Money money) {
        if (!currency.equals(money.currency)) {
            throw new IllegalArgumentException("Cannot add two Money objects with different currencies");
        }
        return new Money(currency, amount - money.amount);
    }

    public Money multiply(int m) {
        return new Money(currency, amount * m);
    }

    @Override
    public int hashCode() {
        return Objects.hash(currency, amount);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Money money = (Money) obj;

        return amount.equals(money.amount) && currency == money.currency;
    }
}
