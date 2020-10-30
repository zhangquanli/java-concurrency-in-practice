package chapter_04.code_05;

import net.jcip.annotations.NotThreadSafe;

/**
 * 程序清单 4-5 与 java.awt.Point 类似的可变 Point 类（不要这么做）
 */
@NotThreadSafe
public class MutablePoint {
    public int x, y;

    public MutablePoint() {
        x = 0;
        y = 0;
    }

    public MutablePoint(MutablePoint p) {
        this.x = p.x;
        this.y = p.y;
    }
}
