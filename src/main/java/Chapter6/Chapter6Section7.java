package Chapter6;

import util.Order;
import util.OrderLine;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Chapter6Section7 {
    public static void main(String[] args) {
        //TODO Map+Flatten 데이터에 함수를 적용한 후 중첩된 stream을 연결하여 하나의 stream을 리턴
        String[][] cities = new String[][] {
                { "Seoul", "Busan" },
                { "San Francisco", "New York" },
                { "Madrid", "Barcelona" }
        };
        Stream<String[]> cityStream=Arrays.stream(cities);
        Stream<Stream<String>> cityStreamsStreams=cityStream.map(x-> Arrays.stream(x));
        List<Stream<String>> cityList=cityStreamsStreams.toList();
        // 넘 복잡하고 이상한 리스트가 나온다 그래서
        Stream<String[]> cityStream2=Arrays.stream(cities);
        Stream<String> flattenedCityStream=cityStream2.flatMap(x->Arrays.stream(x));
        List<String> flattenedCityStream2=flattenedCityStream.toList();
        System.out.println(flattenedCityStream2);

        Order order1 = new Order()
                .setId(1001)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10001)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(5000)),
                        new OrderLine()
                                .setId(10002)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(4000))
                ));
        Order order2 = new Order()
                .setId(1002)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10003)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2000)),
                        new OrderLine()
                                .setId(10004)
                                .setType(OrderLine.OrderLineType.DISCOUNT)
                                .setAmount(BigDecimal.valueOf(-1000))
                ));
        Order order3 = new Order()
                .setId(1003)
                .setOrderLines(Arrays.asList(
                        new OrderLine()
                                .setId(10005)
                                .setType(OrderLine.OrderLineType.PURCHASE)
                                .setAmount(BigDecimal.valueOf(2000))
                ));
        List<Order> orders = Arrays.asList(order1, order2, order3);
        //TODO  3개의 주문을 하나의 주문으로 만들고 싶다.
        List<OrderLine> mergedOrderLines=orders.stream()
                .map(Order::getOrderLines)
                .flatMap(List::stream)
                .toList();
        System.out.println(mergedOrderLines);

    }
}
