package Chapter8;

import Chapter8.Service.EmailService;
import Chapter8.model.User;

import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

public class Chapter8Section10 {
    public static void main(String[] args) {
        //TODO 병력 스트림 처리
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
                .setEmailAddress("charlie@fastcampus.co.kr");
        User user4 = new User()
                .setId(104)
                .setName("David")
                .setEmailAddress("david@fastcampus.co.kr")
                .setVerified(true);
        User user5 = new User()
                .setId(105)
                .setName("Eve")
                .setEmailAddress("eve@fastcampus.co.kr")
                .setVerified(false);
        User user6 = new User()
                .setId(106)
                .setName("Frank")
                .setEmailAddress("frank@fastcampus.co.kr")
                .setVerified(false);
        User user7 = new User()
                .setId(106)
                .setName("Frank")
                .setEmailAddress("frank@fastcampus.co.kr")
                .setVerified(false);
        User user8 = new User()
                .setId(106)
                .setName("Frank")
                .setEmailAddress("frank@fastcampus.co.kr")
                .setVerified(false);
        User user9 = new User()
                .setId(106)
                .setName("Frank")
                .setEmailAddress("frank@fastcampus.co.kr")
                .setVerified(false);
        User user10 = new User()
                .setId(106)
                .setName("Frank")
                .setEmailAddress("frank@fastcampus.co.kr")
                .setVerified(false);

        List<User> users = Arrays.asList(user1, user2, user3, user4, user5, user6,user7,user8,user9,user10);

        long startTime = System.currentTimeMillis();
        EmailService emailService = new EmailService();
        users.stream()
                .filter(user->!user.isVerified())
                .forEach(emailService::sendVerifyYourEmailEmail);
        long endTime=System.currentTimeMillis();
        System.out.println("Sequential : "+(endTime-startTime)+"ms");

         startTime = System.currentTimeMillis();
        users.stream().parallel()
                .filter(user->!user.isVerified())
                .forEach(emailService::sendVerifyYourEmailEmail);
        endTime=System.currentTimeMillis();
        System.out.println("Parallel : "+(endTime-startTime)+"ms");
        //TODO 병렬처리는 중간에는 값이 섞인다. 결과는 순서대로 쌓임 개발자의 판단에 따라 성능이 달라진다.
        List<User> processUsers=users.parallelStream()
                .map(user->{
                    System.out.println("Capitalize user name for user "+user.getId());
                    user.setName(user.getName().toUpperCase());
                    return user;
                })
                .map( user -> {
                    System.out.println("Set isVerified to true for user"+user.getId());
                    user.setVerified(true);
                    return user;
                })
                .collect(Collectors.toList());
        System.out.println(processUsers);


    }
}
