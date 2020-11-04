package chapter_05.code_13;

/**
 * 程序清单 5-13 强制将未检查的 Throwable 转换为 RuntimeException
 */
public class LaunderThrowable {
    /**
     * 如果 Throwable 是 Error，那么抛出它，如果是 RuntimeException，那么返回它，否则抛出 IllegalStateException
     */
    public static RuntimeException launderThrowable(Throwable t) {
        if (t instanceof RuntimeException) {
            return (RuntimeException) t;
        } else if (t instanceof Error) {
            throw (Error) t;
        } else {
            throw new IllegalStateException("Not unchecked", t);
        }
    }
}
