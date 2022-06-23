import util.Adder;

import java.util.function.Function;

public class Chapsection1 {
    public static void main(String[] args) {
        Function<Integer,Integer> myAdder=new Adder();
        int result=myAdder.apply(5);
        System.out.println(result);
    }
}
