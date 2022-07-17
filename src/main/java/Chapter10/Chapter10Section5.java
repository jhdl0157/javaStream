package Chapter10;

import Chapter10.model.User;
import Chapter10.service.InternalUserService;
import Chapter10.service.UserService;
import Chapter10.service.UserServiceInFunctionalWay;

import java.util.Arrays;

public class Chapter10Section5 {
    public static void main(String[] args) {
//        템플릿 메소드 패턴
//        상위클래스는 알고리즘의 뼈대만 정의하고 알고리즘의 각 단계는 하위 클래스에게 정의를 위임하는 패턴
//        알고리즘의 구조를 변경하지 않고 세부 단계들을 유연하게 변경할수 있게 해준다.
        User alice = User.builder(1, "Alice")
                .with(builder -> {
                    builder.emailAddress = "alice@fastcampus.co.kr";
                    builder.isVerified = false;
                    builder.friendUserIds = Arrays.asList(201, 202, 203, 204, 211, 212, 213, 214);
                }).build();

        UserService userService=new UserService();
        InternalUserService internalUserService=new InternalUserService();

        userService.createUser(alice);
        internalUserService.createUser(alice);

        //템플릿을 유연하게 만들어보자

        UserServiceInFunctionalWay userServiceInFunctionalWay=new UserServiceInFunctionalWay(
                user->{
                    System.out.println("validating user "+ user.getName());
                    return user.getName()!=null && user.getEmailAddress().isPresent();
                },
                user ->{
                    System.out.println("Writing user"+user.getName()+"to DB");
                }
        );

        userServiceInFunctionalWay.createUser(alice);



    }
}
