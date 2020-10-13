package chapter_08.code_14;

import java.util.LinkedList;
import java.util.List;

/**
 * 程序清单 8-14 用于谜题解决框架的链表节点
 *
 * @param <P> 位置类
 * @param <M> 移动类
 */
public class PuzzleNode<P, M> {
    private final P pos;
    private final M move;
    private final PuzzleNode<P, M> prev;

    public PuzzleNode(P pos, M move, PuzzleNode<P, M> prev) {
        this.pos = pos;
        this.move = move;
        this.prev = prev;
    }

    public P getPos() {
        return pos;
    }

    public M getMove() {
        return move;
    }

    public PuzzleNode<P, M> getPrev() {
        return prev;
    }

    public List<M> asMoveList() {
        List<M> solution = new LinkedList<>();
        for (PuzzleNode<P, M> n = this; n.move != null; n = n.prev) {
            solution.add(0, n.move);
        }
        return solution;
    }
}
