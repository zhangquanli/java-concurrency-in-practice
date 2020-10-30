package chapter_03.code_15;

/**
 * 程序清单 3-15 由于未被正确发布，因此这个类可能出现故障
 */
public class Holder {
    private int n;

    public Holder(int n) {
        this.n = n;
    }

    public void assertSanity() {
        if (n != n) {
            throw new AssertionError("This statement is false");
        }
    }
}
