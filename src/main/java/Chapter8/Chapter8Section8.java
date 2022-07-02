package Chapter8;


import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Chapter8Section8 {
    public static void main(String[] args) {
        List<Integer> numbers= Arrays.asList(13,2,101,203,304,402,305,349,2312,203);
        Map<Boolean,List<Integer>> numberPartitions=numbers.stream()
                .collect(Collectors.partitioningBy(number->number%2==0));
        System.out.println("Even number :"+numberPartitions.get(true));
        System.out.println("Odd number :"+numberPartitions.get(false));
    }
}
