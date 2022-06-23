import java.util.function.Supplier;

public class ChapterSection4 {
    public static void main(String[] args) {
        //서플라이어는 무언가를 받으면 리턴만 해준다.
        Supplier<String> myStringSupplier=()->"hello world";
        System.out.println(myStringSupplier.get());
        Supplier<Double> myRandomSupplier=()-> Math.random();
        printRandomDoubles(myRandomSupplier,10);


    }
//이 함수는 랜덤 로직에 전혀 영향을 안받는다. 그저 출력만 할뿐
    public static void printRandomDoubles(Supplier<Double> randomSupplier,int count){
        for(int i=0;i<count;i++){
            System.out.println(randomSupplier.get());
        }
    }
}
