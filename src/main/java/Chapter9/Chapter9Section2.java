package Chapter9;

import java.util.List;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter9Section2 {
    public static void main(String[] args) {
        //Lazy Evaluation 계산을 최대한 미룬다.

        //returnTrue만 실행된다.
        if(returnTrue() || returnFalse()){
            System.out.println("true");
        }

        //최적화가 안된다.
        if(or(returnTrue(),returnFalse())){
            System.out.println("true");
        }
        //returnFalse 를 안한다.
        if(lazyOr( () ->returnTrue(),()->returnFalse())){
            System.out.println("true");
        }

        //스트림에서 Lazy
        Stream<Integer> integerStream= Stream.of(3,-2,5,8,-3,8)
                .filter(x->x>0)
                .peek(x-> System.out.println("Peeking "+x))
                .filter(x-> x%2==0);
        System.out.println("Before collect");

        //스트림은 사용이 될때까지 계산을 미룬다. 출력을 보면 Before가 먼저 나오고 peek작업이 실행된다. 쓰이기 전까지는
        //연산을 미룬다.
        List<Integer> integerList=integerStream.collect(Collectors.toList());
        System.out.println("After collect "+integerList);


    }
    public static boolean or(boolean x,boolean y){
        return x||y;
    }
    public static boolean lazyOr(Supplier<Boolean> x,Supplier<Boolean> y){
        return x.get()||y.get();
    }
    public static boolean returnTrue(){
        System.out.println("Returning true");
        return true;
    }
    public static boolean returnFalse(){
        System.out.println("Returning false");
        return false;
    }
}
