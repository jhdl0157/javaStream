package Chapter6;

import util.Order;
import util.User;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;

public class Chapter6Section5 {
    public static void main(String[] args) {
        //TODO : 데이터 정렬을 위한 stream sorted사용해보기\
        List<Integer> numbers= Arrays.asList(3,-5,7,4);
        List<Integer> sortedNumbers=numbers.stream()
                .sorted()
                .toList();
        System.out.println(sortedNumbers);

        User user1 = new User()
                .setId(101)
                .setName("Paul")
                .setVerified(true)
                .setEmailAddress("alice@fastcampus.co.kr");

        User user2 = new User()
                .setId(102)
                .setName("David")
                .setVerified(false)
                .setEmailAddress("bob@fastcampus.co.kr");

        User user3 = new User()
                .setId(103)
                .setName("John")
                .setVerified(false)
                .setEmailAddress("Charlie@fastcampus.co.kr");
        List<User> users = Arrays.asList(user1, user2, user3);
        //TODO 이름 기준으로 정렬해보기
        List<User> sortedUsers=users.stream()
                .sorted((u1,u2)->u1.getName().compareTo(u2.getName())).toList();
        System.out.println(sortedUsers);

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
        //TODO : 언제 만들어졌는지에 대한 정렬된 오더 리스트 만들어보기
        List<Order> sortedCreatedAtOrder=orders.stream()
                .sorted((x,y)->x.getCreatedAt().compareTo(y.getCreatedAt())).toList();
        System.out.println(sortedCreatedAtOrder);
    }
}
