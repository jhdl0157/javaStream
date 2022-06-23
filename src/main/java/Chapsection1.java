import util.Adder;

import java.util.function.Function;

public class Chapsection1 {
    public static void main(String[] args) {
        //기존 방식
//        Function<Integer,Integer> myAdder=new Adder();
//        int result=myAdder.apply(5);
//        System.out.println(result);
        Function<Integer,Integer> myAdder=(Integer x)->{
            return x+10;
        };
        int result=myAdder.apply(5);
        System.out.println(result);
        //매개변수의 타입이 유추 가능하면 생략가능
        //매개변수가 하나일 경우 괄호 생략가능
        //바로 리턴하는 경우 중괄호 생략 가능
        Function<Integer,Integer> myAdder1=x-> x+10;;
        int results=myAdder.apply(5);
        System.out.println(results);
    }
}
