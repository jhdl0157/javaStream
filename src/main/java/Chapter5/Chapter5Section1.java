package Chapter5;

import java.util.ArrayList;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.List;


public class Chapter5Section1 {
    public static int calculate(int x, int y, BiFunction<Integer,Integer,Integer> operator){
        return operator.apply(x,y);
    }
    public static int multiply(int x,int y){
        return x*y;
    }
    public int subtract(int x,int y){
        return x-y;
    }
    public static void main(String[] args) {
        int a=Integer.parseInt("15");
        Function<String,Integer> str2int=Integer::parseInt;
        System.out.println(str2int.apply("29"));

        String str="hello";
        boolean b=str.equals("world");
        Predicate<String> equalsToHello=str::equals;
        System.out.println(equalsToHello.test("world"));
        System.out.println(calculate(8,2,(x,y)->x+y));
        System.out.println(calculate(8,2,Chapter5Section1::multiply));
        Chapter5Section1 instance=new Chapter5Section1();
        System.out.println(calculate(8,2,instance::subtract));
        List<User> users=new ArrayList<>();
        users.add(new User(3,"asd"));
        users.add(new User(1,"test1"));
        users.add(new User(6,"test2"));
        printUseField(users,User::getName);

    }
    public static void printUseField(List<User> users,Function<User,Object> getter){
        for(User user :users){
            System.out.println(getter.apply(user));
        }

    }
}
