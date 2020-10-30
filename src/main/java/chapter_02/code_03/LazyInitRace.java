package chapter_02.code_03;

import net.jcip.annotations.NotThreadSafe;

/**
 * 程序清单 2-3 延迟初始化中的竞态条件（不要这么做）
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
