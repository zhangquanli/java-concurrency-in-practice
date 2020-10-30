package chapter_04.code_10;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 程序清单 4-10 NumberRange 类不足以保护它的不变行条件（不要这么做）
 */
public class NumberRange {
    // 不变性条件：lower <= upper
    private final AtomicInteger lower = new AtomicInteger(0);
    private final AtomicInteger upper = new AtomicInteger(0);

    public void setLower(int i) {
        // 注意——不安全的“先检查后执行”
        if (i > upper.get()) {
            throw new IllegalArgumentException("can't set lower to " + i + " > upper");
        }
        lower.set(i);
    }

    public void setUpper(int i) {
        // 注意——不安全的“先检查后执行”
        if (i < lower.get()) {
            throw new IllegalArgumentException("can't set upper to " + i + " < lower");
        }
        upper.set(i);
    }

    public boolean isInRange(int i) {
        return i >= lower.get() && i <= upper.get();
    }
}
