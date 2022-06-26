package Chapter7;

import util.User;

import java.util.Optional;

public class Chapter7Section1 {
    public static void main(String[] args) {
//        TODO 옵셔널 공부해보기
//          NULL에러는 런타임 에러이기 떄문에 매우 치명적

        User user1 = new User() //이메일은 안넣어줬다.
                .setId(1001)
                .setName("Alice")
                .setVerified(false);

        User user2 = new User()
                .setId(1001)
                .setName("Alice")
                .setEmailAddress("alice@fastcampus.co.kr")
                .setVerified(false);
        System.out.println("Same? : "+userEquals(user2,user1));  //런타임이 널포인트 에러가 난다.
    //Optional null 일수도 아닐수 도 있는 오브젝트를 담는 상자
        String someEmail="some@emil.com";
        String nullEmail=null;

        Optional<String> maybeEmail1=Optional.of(someEmail);
        Optional<String> maybeEmail2=Optional.empty();
        Optional<String> maybeEmail3=Optional.ofNullable(someEmail);
        Optional<String> maybeEmail4=Optional.ofNullable(nullEmail);

        String email=maybeEmail1.get();
        System.out.println(email);
        //NULL이라면 체킹을 해주고 해준다.
        if(maybeEmail2.isPresent()){
            System.out.println(maybeEmail2.get());
        }
        String defaultEmail="deault@email.com";
        String email3= maybeEmail2.orElse(defaultEmail);
        System.out.println(email3);

        //Null 이라면 Supplier를 통해 값을 넣어준다.
        String email4=maybeEmail2.orElseGet(()->defaultEmail);
        System.out.println(email4);

        String email5=maybeEmail2.orElseThrow(()->new RuntimeException("이메일이 없습니다."));
        System.out.println(email5);
    }
    public static boolean userEquals(User u1, User u2){
        return u1.getId()== u2.getId()
                && u1.getName().equals(u2.getName())
                && u1.getEmailAddress().equals(u2.getEmailAddress())
                && u1.isVerified()==u2.isVerified();
    }
}
