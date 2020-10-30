package chapter_04.code_06;

import net.jcip.annotations.Immutable;

/**
 * 程序清单 4-6 在 DelegatingVehicleTracker 中使用的不可变 Point 类
 */
@Immutable
public class Point {
    public final int x, y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}
