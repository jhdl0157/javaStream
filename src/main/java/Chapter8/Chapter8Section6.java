package Chapter8;

import Chapter8.model.Order;
import Chapter8.model.User;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter8Section6 {
    public static void main(String[] args) {
        //Stream 안에 데이터를 Map으로 반환
        Map<Integer,String> numberMap= Stream.of(3,5,-4,2,6)
                .collect(Collectors.toMap(
                        Function.identity(), //키
                        x->"Number i "+x) //벨류
                );
        System.out.println(numberMap.get(3));
        User user1 = new User()
                .setId(101)
                .setName("Paul")
                .setVerified(true)
                .setEmailAddress("alice@fastcampus.co.kr");

        User user2 = new User()
                .setId(102)
                .setName("David")
                .setVerified(true)
                .setEmailAddress("bob@fastcampus.co.kr");

        User user3 = new User()
                .setId(103)
                .setName("John")
                .setVerified(true)
                .setEmailAddress("Charlie@fastcampus.co.kr");
        List<User> users = Arrays.asList(user1, user2, user3);
        Map<Integer,User> userIdMap=users.stream()
                .collect(Collectors.toMap(
                        User::getId,
                        Function.identity()
                ));
        System.out.println(userIdMap);
        System.out.println(userIdMap.get(103));
        //TODO 오더 아이디에서 오더 스테이터스로 맵핑
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
        Map<Long, Order.OrderStatus> orderIdToOrderStatusMap=orders.stream()
                .collect(Collectors.toMap(
                        Order::getId,
                        Order::getStatus
                ));
        System.out.println(orderIdToOrderStatusMap);

    }
}
