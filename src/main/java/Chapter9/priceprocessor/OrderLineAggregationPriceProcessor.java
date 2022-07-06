package Chapter9.priceprocessor;

import java.math.BigDecimal;
import java.util.function.Function;

import Chapter9.model.Order;
import Chapter9.model.OrderLine;

public class OrderLineAggregationPriceProcessor implements Function<Order, Order> {

    @Override
    public Order apply(Order order) {
        return order.setAmount(order.getOrderLines().stream()
                .map(OrderLine::getAmount)
                .reduce(BigDecimal.ZERO, BigDecimal::add));
    }

}
