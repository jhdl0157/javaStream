package Chapter8;

import java.util.Arrays;
import java.util.List;

public class Chapter8Section4 {
    public static void main(String[] args) {
        //TODO REDUCE 적용
        List<Integer> numbers= Arrays.asList(1,-4,-2,-5,3);

        int sum=numbers.stream()
                .reduce((x,y)->x+y)
                .get();
        System.out.println(sum);

        int min=numbers.stream()
                .reduce((x,y) -> x< y ? x : y)
                .get();
        System.out.println(min);

        int product=numbers.stream()
                .reduce(1,(x,y)->x*y);
        System.out.println(product);


    }
}
