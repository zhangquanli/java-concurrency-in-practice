package chapter_03.code_03_14;

import chapter_03.code_03_15.Holder;

/**
 * Publishing an object without adequate synchronization.
 */
public class StuffIntoPublic {
    public Holder holder;

    public void initialize() {
        holder = new Holder(42);
    }
}
