package Chapter6;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Chapter6Section1 {
    public static void main(String[] args) {
        Stream<String> nameStream=Stream.of("Alice","Bob","Charlie");
        List<String> nameString=nameStream.collect(Collectors.toList());
        System.out.println(nameString);

        String[] cityArray=new String[]{"Seoul","Tokyo","San Jose"};
        Stream<String> cityStream= Arrays.stream(cityArray);
        List<String> cityList=cityStream.collect(Collectors.toList());
        System.out.println(cityList);

        Set<Integer> numberSet=new HashSet<>(Arrays.asList(3,5,7));
        Stream<Integer> numberStream=numberSet.stream();
        List<Integer> numberList=numberStream.collect(Collectors.toList());
        System.out.println(numberList);
    }
}
