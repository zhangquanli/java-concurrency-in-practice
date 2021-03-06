package chapter_05.code_16;

import net.jcip.annotations.GuardedBy;

import java.util.HashMap;
import java.util.Map;

/**
 * 程序清单 5-16 使用 HashMap 和同步机制来初始化缓存
 */
public class Memoizer1<A, V> implements Computable<A, V> {
    @GuardedBy("this")
    private final Map<A, V> cache = new HashMap<>();
    private final Computable<A, V> c;

    public Memoizer1(Computable<A, V> c) {
        this.c = c;
    }

    public synchronized V compute(A arg) throws InterruptedException {
        V result = cache.get(arg);
        if (result == null) {
            result = c.compute(arg);
            cache.put(arg, result);
        }
        return result;
    }
}
