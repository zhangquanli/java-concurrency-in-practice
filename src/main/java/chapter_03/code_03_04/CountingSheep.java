package chapter_03.code_03_04;

/**
 * Counting sheep.
 */
public class CountingSheep {
    volatile boolean asleep;

    public void tryToSleep() {
        while (!asleep) {
            countSomeSheep();
        }
    }

    private void countSomeSheep() {
        // One, two, three...
    }
}
