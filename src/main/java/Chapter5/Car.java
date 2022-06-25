package Chapter5;

public abstract class Car {
    protected  String name;
    protected  String brand;
    public Car(String name,String brand){
        this.brand=brand;
        this.name=name;
    }
    public abstract void drive();
}
