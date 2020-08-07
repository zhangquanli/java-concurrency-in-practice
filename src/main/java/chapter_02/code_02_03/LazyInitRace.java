package chapter_02.code_02_03;

import net.jcip.annotations.NotThreadSafe;

/**
 * Race condition in lazy initialization.
 */
@NotThreadSafe
public class LazyInitRace {
    private ExpensiveObject instance = null;

    public ExpensiveObject getInstance() {
        if (instance == null) {
            instance = new ExpensiveObject();
        }
        return instance;
    }

    private static class ExpensiveObject {
    }
}
