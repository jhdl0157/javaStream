package Chapter8;



import Chapter8.model.Order;
import Chapter8.model.User;


import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Chapter8Section1 {
    public static void main(String[] args) {
    Optional<Integer> max=Stream.of(5,3,6,2,1)
            .max(Integer::compareTo);
        System.out.println(max.get());
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
        User firstUser=users.stream()
                .min((u1,u2)->u1.getName().compareTo(u2.getName()))
                .get();
        System.out.println(firstUser);

        long positiveIntegerCount=Stream.of(1,-4,5,-3,6)
                .filter(x->x>0)
                .count();
        System.out.println(positiveIntegerCount);

        LocalDateTime now=LocalDateTime.now(ZoneId.of("Asia/Seoul"));
        user1.setCreatedAt(now.minusDays(2));
        user2.setCreatedAt(now.minusHours(10));
        user3.setCreatedAt(now.minusHours(1));
        User user4 = new User()
                .setId(103)
                .setName("Jaeho")
                .setVerified(true)
                .setEmailAddress("sdd21@fastcampus.co.kr")
                .setCreatedAt(now.minusHours(27));
        List<User> users1 = Arrays.asList(user1, user2, user3,user4);
        long userCount=users1.stream()
                .filter(user->user.getCreatedAt().isAfter(now.minusDays(1)))
                .filter(user -> !user.isVerified())
                .count();

        System.out.println("카운트: "+userCount);

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

        //TODO: 에러중에서 가장 큰값인 오더들
        Order ErrorAndAmount=orders.stream()
                .filter(order -> order.getStatus()== Order.OrderStatus.ERROR)
                .max(((o1, o2) -> o1.getAmount().compareTo(o2.getAmount())))
                .get();
        System.out.println(ErrorAndAmount);

        BigDecimal maxErrorAmount=orders.stream()
                .filter(order -> order.getStatus()== Order.OrderStatus.ERROR)
                .map(Order::getAmount)
                .max(BigDecimal::compareTo)
                .orElse(null);

        System.out.println(maxErrorAmount);

    }
}
