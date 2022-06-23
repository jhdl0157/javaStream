import java.util.function.BiFunction;

public class ChapterSection3 {
    public static void main(String[] args) {
        //매개변수가 2개이상일떄
        BiFunction<Integer,Integer,Integer> add=(Integer x, Integer y) -> {
            return x+y;
        };
        int result=add.apply(3,5);
        System.out.println(result);
        //매개변수 인풋타입은 유추 가능하니 생략
        BiFunction<Integer,Integer,Integer> add1=( x,  y) -> x+y;
        int result1=add1.apply(3,5);
        System.out.println(result1);
    }
}
