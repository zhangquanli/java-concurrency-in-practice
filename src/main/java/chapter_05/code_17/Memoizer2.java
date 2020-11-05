package chapter_05.code_17;

import chapter_05.code_16.Computable;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 程序清单 5-17 用 ConcurrentHashMap 替换 HashMap
 */
public class Memoizer2<A, V> implements Computable<A, V> {
    private final Map<A, V> cache = new ConcurrentHashMap<>();
    private final Computable<A, V> c;

    public Memoizer2(Computable<A, V> c) {
        this.c = c;
    }

    public V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
