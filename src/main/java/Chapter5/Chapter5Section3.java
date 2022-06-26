package Chapter5;

import util.User;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

public class Chapter5Section3 {
    public static void main(String[] args) {
        Map<String,BiFunction<String,String,Car>> carTypeToConstructorMap= new HashMap<>();
//        User user=new User(1,"allies");
//        BiFunction<Integer,String,User> userCreate=(Integer id,String name)-> new User(id,name);
//        BiFunction<Integer,String,User> userCreate2= User::new;
//        User charlie=userCreate2.apply(1,"안녕");
//        System.out.println(charlie.toString());

        String[][] inputs=new String[][]{
                {"sedan","Sonata","Hyundai"},
                {"van","Sienna","Toyota"},
                {"sedan","Model s","Tesla"},
                {"suv","Sorento","KIA"}
        };
        carTypeToConstructorMap.put("sedan",Sedan::new);
        carTypeToConstructorMap.put("suv",Suv::new);
        carTypeToConstructorMap.put("van",Van::new);

        List<Car> cars=new ArrayList<>();
        for(int i=0;i<inputs.length;i++){
            String[] input=inputs[i];
            String carType=input[0];
            String name=input[1];
            String brand=input[2];

            cars.add(carTypeToConstructorMap.get(carType).apply(name,brand));
        }
        for(Car car:cars){
            car.drive();
        }

    }
}
