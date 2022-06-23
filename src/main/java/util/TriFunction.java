package util;

//FunctionalInterface는 단하나의 추상 매서드를 가진 인터페이스이다.
@FunctionalInterface
public interface TriFunction<T,U,V,R> {
    R apply(T t,U u, V v);
}
