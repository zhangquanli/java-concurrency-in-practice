package chapter_08.code_15;

import chapter_08.code_13.Puzzle;
import chapter_08.code_14.PuzzleNode;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 程序清单 8-15 串行的谜题解答器
 *
 * @param <P> 位置类
 * @param <M> 移动类
 */
public class SequentialPuzzleSolver<P, M> {
    private final Puzzle<P, M> puzzle;
    private final Set<P> seen = new HashSet<>();

    public SequentialPuzzleSolver(Puzzle<P, M> puzzle) {
        this.puzzle = puzzle;
    }

    public List<M> solve() {
        P position = puzzle.initialPosition();
        return search(new PuzzleNode<>(position, null, null));
    }

    private List<M> search(PuzzleNode<P, M> node) {
        if (!seen.contains(node.getPos())) {
            seen.add(node.getPos());
            if (puzzle.isGoal(node.getPos())) {
                return node.asMoveList();
            }
            for (M move : puzzle.legalMoves(node.getPos())) {
                P position = puzzle.move(node.getPos(), move);
                PuzzleNode<P, M> child = new PuzzleNode<>(position, move, node);
                List<M> result = search(child);
                if (result != null) {
                    return result;
                }
            }
        }
        return null;
    }
}
