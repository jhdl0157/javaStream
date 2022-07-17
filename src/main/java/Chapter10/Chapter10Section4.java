package Chapter10;

import Chapter10.model.User;
import Chapter10.service.EmailProvidcer;
import Chapter10.service.EmailSender;
import Chapter10.service.MakeMoreFriendsEmailProvider;
import Chapter10.service.VerifyYourEmailAddressEmailProvider;

import java.util.Arrays;
import java.util.List;

public class Chapter10Section4 {
    public static void main(String[] args) {
        //스트레티지 패턴
        User user1 = User.builder(1, "Alice")
                .with(builder -> {
                    builder.emailAddress = "alice@fastcampus.co.kr";
                    builder.isVerified = false;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
                }).build();
        User user2 = User.builder(2, "Bob")
                .with(builder -> {
                    builder.emailAddress = "bob@fastcampus.co.kr";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(212, 213, 214);
                }).build();
        User user3 = User.builder(3, "Charlie")
                .with(builder -> {
                    builder.emailAddress = "charlie@fastcampus.co.kr";
                    builder.isVerified = true;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212);
                }).build();
        List<User> users = Arrays.asList(user1, user2, user3);
        EmailSender emailSender=new EmailSender();
        EmailProvidcer verifyYourEmailAddressEmailProvider=new VerifyYourEmailAddressEmailProvider();
        EmailProvidcer makeMoreFriendsEmailProvider=new MakeMoreFriendsEmailProvider();

        //원하는 전략으로 이메일을 보낼수 있다.
        emailSender.setEmailProvider(verifyYourEmailAddressEmailProvider);

        users.stream()
                .filter(user -> !user.isVerified())
                .forEach(emailSender::sendEmail);

        //전략을 바꿔본다.
        emailSender.setEmailProvider(makeMoreFriendsEmailProvider);
        users.stream()
                .filter(User::isVerified)
                .filter(user -> user.getFriendUserIds().size() <= 5)
                .forEach(emailSender::sendEmail);
        //함수형 인터페이스로 정의를 해서 클래스를 만들지 않고 바로 적용이 가능하다.
        emailSender.setEmailProvider(user -> "Play with Friends email for "+user.getName());
        users.stream()
                .filter(User::isVerified)
                .filter(user -> user.getFriendUserIds().size() >5)
                .forEach(emailSender::sendEmail);

    }
}
