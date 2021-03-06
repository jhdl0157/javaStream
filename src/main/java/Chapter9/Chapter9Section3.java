package Chapter9;

import Chapter9.model.Order;
import Chapter9.model.OrderLine;
import Chapter9.priceprocessor.OrderLineAggregationPriceProcessor;
import Chapter9.priceprocessor.TaxPriceProcessor;

import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

public class Chapter9Section3 {
    public static void main(String[] args) {
        File file=new File("D:\\javaSsg\\src\\main\\java\\data\\5.json");
        if(file.delete()){
            System.out.println("파일 삭제 완료");
        }
        // Function Composition
        Function<Integer,Integer> multiplyByTwo=x-> x*2;
        Function<Integer,Integer> addTen=x-> x+10;
        //입력받은 숫자에 2를 곱하고 10을 더해준다.
        Function<Integer,Integer> composedFunction=multiplyByTwo.andThen(addTen);
        System.out.println(composedFunction.apply(3));

        Order unprocessedOrder = new Order()
                .setId(1001L)
                .setOrderLines(Arrays.asList(
                        new OrderLine().setAmount(BigDecimal.valueOf(1000)),
                        new OrderLine().setAmount(BigDecimal.valueOf(2000))));

        List<Function<Order, Order>> priceProcessors = getPriceProcessors(unprocessedOrder);

        Function<Order, Order> mergedPriceProcessors = priceProcessors.stream()
                .reduce(Function.identity(), Function::andThen);

        Order processedOrder = mergedPriceProcessors.apply(unprocessedOrder);
        System.out.println(processedOrder);
    }
    public  static  List<Function<Order,Order>> getPriceProcessors(Order order){
        return Arrays.asList(new OrderLineAggregationPriceProcessor(),
                new TaxPriceProcessor(new BigDecimal("9.375")));

    }
}
