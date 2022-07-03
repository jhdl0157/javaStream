package Chapter8;

import Chapter8.Service.EmailService;
import Chapter8.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Chapter8Section9 {
    public static void main(String[] args) {
        //ForEach 사용
        List<Integer> numbers= Arrays.asList(3,5,2,1);
        numbers.stream().forEach(number->
                        System.out.println("The number is "+number) //컨슈머
                );
        numbers.forEach(number-> System.out.println("The number is "+number));
        User user1 = new User()
                .setId(101)
                .setName("Paul")
                .setVerified(false)
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
        EmailService emailService=new EmailService();
        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailService::sendVerifyYourEmailEmail);

        //TODO IntStream을 사용하면 오래된 for문 대체 가능
        IntStream.range(0,users.size()).forEach(i->{
            User user=users.get(i);
            System.out.println("Do an operation on user "+user.getName()+" at index"+i);
        });

    }
}
