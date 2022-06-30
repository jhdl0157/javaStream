package Chapter8;

import Chapter8.model.Order;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Chapter8Section7 {
    public static void main(String[] args) {
        //groupBy
        List<Integer> numbers= Arrays.asList(13,2,101,203,304,402,305,349,2312,203);
        Map<Integer,List<Integer>> unitDigitMap=numbers.stream()
                .collect(Collectors.groupingBy(
                        number->number%10
                ));
        System.out.println(unitDigitMap);

        Map<Integer, Set<Integer>>unitDigitSet=numbers.stream()
                .collect(Collectors.groupingBy(
                        number->number%10,Collectors.toSet()
                ));
        System.out.println(unitDigitSet);

        Map<Integer,List<String>> unitDigitString=numbers.stream()
                .collect(Collectors.groupingBy(
                        number->number%10,
                        Collectors.mapping(number ->"unit digit is "+number,Collectors.toList())));
        System.out.println(unitDigitString);
        System.out.println(unitDigitString.get(3));

        Order order1 = new Order()
                .setId(1001L)
                .setAmount(BigDecimal.valueOf(2000))
                .setStatus(Order.OrderStatus.CREATED);
        Order order2 = new Order()
                .setId(1002L)
                .setAmount(BigDecimal.valueOf(4000))
                .setStatus(Order.OrderStatus.ERROR);
        Order order3 = new Order()
                .setId(1003L)
                .setAmount(BigDecimal.valueOf(3000))
                .setStatus(Order.OrderStatus.ERROR);
        Order order4 = new Order()
                .setId(1004L)
                .setAmount(BigDecimal.valueOf(7000))
                .setStatus(Order.OrderStatus.PROCESSED);
        List<Order> orders = Arrays.asList(order1, order2, order3, order4);
        //TODO ORDERSTATUS별로 오더를 묶어봐라
        Map<Order.OrderStatus,List<Order>> orderStatusOrderMap=orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus));
        System.out.println(orderStatusOrderMap);

        Map<Order.OrderStatus,BigDecimal> orderStatusIntegerMap=orders.stream()
                .collect(Collectors.groupingBy(Order::getStatus,
                        Collectors.mapping(Order::getAmount,
                                Collectors.reducing(BigDecimal.ZERO,BigDecimal::add))));
        System.out.println(orderStatusIntegerMap);
    }
}
