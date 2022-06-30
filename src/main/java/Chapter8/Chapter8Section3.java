package Chapter8;

import java.util.Optional;
import java.util.stream.Stream;

public class Chapter8Section3 {
    public static void main(String[] args) {
        //findany findall
        Optional<Integer> anyNegative=Stream.of(3,2,-5,6)
                .filter(x->x<0)
                .findAny();
        System.out.println(anyNegative.get());

        Optional<Integer> firstPositiveInteger=Stream.of(3,2,-5,6)
                .filter(x->x>0)
                .findFirst();
        System.out.println(firstPositiveInteger.get());


    }
}