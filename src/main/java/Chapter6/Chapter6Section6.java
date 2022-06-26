package Chapter6;

import util.Order;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

public class Chapter6Section6 {
    public static void main(String[] args) {
        //TODO 중복된 데이터 제거 해보기(distinct 사용)
        List<Integer> numbers= Arrays.asList(3,-5,4,-5,2,3);
        List<Integer> distinctNumbers=numbers.stream()
                .distinct()
                .sorted()
                .toList();

        System.out.println(distinctNumbers);

        LocalDateTime now=LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101)
                .setCreatedAt(now.minusHours(4));
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(102)
                .setCreatedAt(now.minusHours(1));

        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(103)
                .setCreatedAt(now.minusHours(36));
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104)
                .setCreatedAt(now.minusHours(40));
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(101)
                .setCreatedAt(now.minusHours(10));
        List<Order> orders=Arrays.asList(order1,order2,order3,order4,order5);
        //TODO: createdByUserId의 리스트를 중복없이 시간순으로 정렬후에 리스트로 뽑아내라
        List<Long> distinctOrderSortedCreatedAtList=orders.stream()
                .distinct()
                .sorted((x,y)->x.getCreatedAt().compareTo(y.getCreatedAt()))
                .map(Order::getCreatedByUserId).toList();
        System.out.println(distinctOrderSortedCreatedAtList);


    }
}
