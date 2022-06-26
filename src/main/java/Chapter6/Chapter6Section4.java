package Chapter6;

import util.Order;
import util.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Chapter6Section4 {
    public static void main(String[] args) {
        //TODO 이번에 목표 소스-> 중간처리-> 종결처리 까지 해보기
        User user1 = new User()
                .setId(101)
                .setName("Alice")
                .setVerified(true)
                .setEmailAddress("alice@fastcampus.co.kr");

        User user2 = new User()
                .setId(102)
                .setName("Bob")
                .setVerified(false)
                .setEmailAddress("bob@fastcampus.co.kr");

        User user3 = new User()
                .setId(103)
                .setName("Charlie")
                .setVerified(false)
                .setEmailAddress("Charlie@fastcampus.co.kr");

        List<User> users = Arrays.asList(user1, user2, user3);
        //TODO 인증이 안된 유저를 찾아 그 유저들의 이메일만 뽑아보기
        List<String> emails= users.stream()
                .filter(user -> !user.isVerified())
                .map(User::getEmailAddress)
                .toList();
        System.out.println(emails);

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
                .setCreatedByUserId(105)
                .setCreatedAt(now.minusHours(10));
        List<Order> orders=Arrays.asList(order1,order2,order3,order4,order5);
        //TODO: 에러상태인 오더에 유저만 리스트에서 만든 아이디를 뽑아 리스트로
        List<Long> errorUserCreatedId=orders.stream().filter(order -> order.getStatus()== Order.OrderStatus.ERROR)
                .map(Order::getCreatedByUserId).toList();
        System.out.println(errorUserCreatedId);

        //TODO 에러 상태인 오더 중에서 만들어진지 24시간 이내의 오더만 골라내기 (now.isafter())
        List<Order> errorOrderCreatedAt24Before=orders.stream().filter(order -> order.getStatus()== Order.OrderStatus.ERROR)
                .filter(order -> order.getCreatedAt().isAfter(now.minusHours(24))).toList();
        System.out.println(errorOrderCreatedAt24Before);


    }
}
