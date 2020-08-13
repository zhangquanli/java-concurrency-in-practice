package chapter_03.code_06;

/**
 * Allowing internal mutable state to escape.
 */
public class UnsafeStates {
    private String[] states = new String[]{"AK", "Al"};

    public String[] getStates() {
        return states;
    }
}
