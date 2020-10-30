package chapter_03.code_06;

/**
 * 程序清单 3-6 使内部的可变状态逸出（不要这么做）
 */
public class UnsafeStates {
    private String[] states = new String[]{"AK", "Al"};

    public String[] getStates() {
        return states;
    }
}
