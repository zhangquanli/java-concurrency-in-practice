package chapter_08.code_13;

import java.util.Set;

/**
 * 程序清单 8-13 表示 “搬箱子” 之类谜题的抽象类
 *
 * @param <P> 位置类
 * @param <M> 移动类
 */
public interface Puzzle<P, M> {
    P initialPosition();

    boolean isGoal(P position);

    Set<M> legalMoves(P position);

    P move(P position, M move);
}
