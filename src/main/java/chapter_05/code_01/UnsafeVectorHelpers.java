package chapter_05.code_01;

import java.util.Vector;

/**
 * 程序清单 5-1 Vector 上可能导致混乱结果的复合操作
 */
public class UnsafeVectorHelpers {
    public static Object getLast(Vector list) {
        int lastIndex = list.size() - 1;
        return list.get(lastIndex);
    }

    public static void deleteLast(Vector list) {
        int lastIndex = list.size() - 1;
        list.remove(lastIndex);
    }
}
