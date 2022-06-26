package Chapter6;

import util.Order;
import util.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter6Section3 {
    //Map에대해서 알아보자
    //데이터를 변형하는데 사용 데이터에 함수가 적용된 결과물을 제공하는 stream리턴
    public static void main(String[] args) {
        List<Integer> numberList = Arrays.asList(3, 6, -4);
        Stream<Integer> numberStream = numberList.stream();
        List<Integer> numberListX2 = numberList.stream().map(x -> x * 2)
                .collect(Collectors.toList());
        //List<Integer> numberListX2=numberSteamX2.collect(Collectors.toList());
        System.out.println(numberListX2);
        //Integer -> String
        Stream<Integer> numberListStream = numberList.stream();
        Stream<String> strStream = numberListStream.map(x -> "NumBer is " + x);
        List<String> strList = strStream.collect(Collectors.toList());
        System.out.println(strList);
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

        //정석 버전
        List<User> users = Arrays.asList(user1, user2, user3);
        Stream<User> userStream = users.stream();
        Stream<String> userEmailSteam = userStream.map(User::getEmailAddress);
        List<String> emailAddress = userEmailSteam.collect(Collectors.toList());
        System.out.println(emailAddress);

        //단 두줄로 줄여버리기
        List<String> usersEmail = Stream.of(user1, user2, user3).map(User::getEmailAddress).toList();
        System.out.println(usersEmail);

        Order order1 = new Order()
                .setId(1001)
                .setStatus(Order.OrderStatus.CREATED)
                .setCreatedByUserId(101);
        Order order2 = new Order()
                .setId(1002)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(102);

        Order order3 = new Order()
                .setId(1003)
                .setStatus(Order.OrderStatus.PROCESSED)
                .setCreatedByUserId(103);
        Order order4 = new Order()
                .setId(1004)
                .setStatus(Order.OrderStatus.ERROR)
                .setCreatedByUserId(104);
        Order order5 = new Order()
                .setId(1005)
                .setStatus(Order.OrderStatus.IN_PROGRESS)
                .setCreatedByUserId(105);
        List<Order> orders=Arrays.asList(order1,order2,order3,order4,order5);
        //TODO:

    }
}
