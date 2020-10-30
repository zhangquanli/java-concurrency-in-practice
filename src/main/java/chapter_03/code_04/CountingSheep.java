package chapter_03.code_04;

/**
 * 程序清单 3-4 数绵羊
 */
public class CountingSheep {
    private volatile boolean asleep;

    public void tryToSleep() {
        while (!asleep) {
            countSomeSheep();
        }
    }

    private void countSomeSheep() {
    }
}
