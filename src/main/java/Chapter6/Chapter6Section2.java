package Chapter6;


import util.Order;
import util.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter6Section2 {
    //filter
    public static void main(String[] args) {
        Stream<Integer> numberStream = Stream.of(3,-5,7,10,-3);
        Stream<Integer> filteredNumbers=numberStream.filter(x->x>0);
        List<Integer> filterNumbers=filteredNumbers.collect(Collectors.toList());
        System.out.println(filterNumbers);
        //한방에 가능
        List<Integer> newFilteredNumber=Stream.of(3,-5,7,10,-3)
                .filter(x->x>0)
                .collect(Collectors.toList());
        System.out.println(newFilteredNumber);

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

        List<User> users= Arrays.asList(user1,user2,user3);

        //이메일 검증 안된 유저 필터링
        List<User> verifiedUsers=users.stream()
                .filter(User::isVerified)
                .collect(Collectors.toList());
        System.out.println(verifiedUsers);

        List<User> unverifiedUsers=users.stream()
                .filter(user -> !user.isVerified())
                .collect(Collectors.toList());
        System.out.println(unverifiedUsers);
        Order order1=new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED);
        Order order2=new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR);
        Order order3=new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED);
        Order order4=new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR);
        Order order5=new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS);
        List<Order> orders=Arrays.asList(order1,order2,order3,order4,order5);
        List<Order> errorOrder=orders.stream()
                .filter(order -> order.getStatus()== Order.OrderStatus.ERROR)
                .collect(Collectors.toList());

        System.out.println(errorOrder);
    }
}