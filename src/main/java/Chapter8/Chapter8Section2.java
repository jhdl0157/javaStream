package Chapter8;

import Chapter8.model.Order;
import Chapter8.model.User;

import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

public class Chapter8Section2 {
    public static void main(String[] args) {
        //ALLmatch stream안에 모든 데이터가 predicate를 만족하면 true
        //Anymatch stream안에 하나가 만족하면 true
        List<Integer> numbers =Arrays.asList(3,-4,2,7,9);
        boolean allPostive=numbers.stream()
                .allMatch(number-> number>0);
        System.out.println("모두 양수?"+allPostive);

        boolean anyNagative=numbers.stream()
                .anyMatch(x -> x>0);
        System.out.println("하나라도 음수 인가 ? :"+anyNagative);
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
        boolean AllUserverified=users.stream().allMatch(User::isVerified);
        System.out.println("모든 유저가 이메일을 인증 했는가? :"+AllUserverified);


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

        //TODO 에러 상태인 오더가 하나라도있는지??
        boolean anyOrderError=orders.stream()
                .anyMatch(x->x.getStatus()== Order.OrderStatus.ERROR);
        System.out.println(anyOrderError);


    }
}
