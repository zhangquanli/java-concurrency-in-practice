package chapter_05.code_16;

public interface Computable<A, V> {
    V compute(A arg) throws InterruptedException;
}
