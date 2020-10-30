package chapter_03.code_14;

import chapter_03.code_15.Holder;

/**
 * 程序清单 3-14 在没有足够同步的情况下发布对象（不要这么做）
 */
public class StuffIntoPublic {
    // 不安全的发布
    public Holder holder;

    public void initialize() {
        holder = new Holder(42);
    }
}
