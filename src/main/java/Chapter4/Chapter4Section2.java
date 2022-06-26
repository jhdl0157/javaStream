package Chapter4;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class Chapter4Section2 {
    public static void main(String[] args) {
        //서플라이어와 다르게 주어진걸 먹어치운다.
        Consumer<String> myStringConsumer= System.out::println;
        myStringConsumer.accept("냠냠냠 이거 다 먹는다.");

        List<Integer> integerInputs= Arrays.asList(4,2,3); //불변 객체이다.
        //integerInputs.add(4); 불가능
        Consumer<Integer> myIntegerProcessor = (x)->{
            System.out.println("프로세싱중: "+x);
        };
        process(integerInputs,myIntegerProcessor);
        Consumer<Integer> myDifferentInteger = x-> System.out.println("다른 프로세스 진행중 "+x);
        process(integerInputs,myDifferentInteger);
    }
//컨슈머 프로세스 로직에 따라서 다양하게 활용이 가능한다.
    public static <T> void process(List<T> inputs, Consumer<T> processor){
      for(T input :inputs){
          processor.accept(input);
      }

    }
}
