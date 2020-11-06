package chapter_08.code_18;

import chapter_08.code_13.Puzzle;
import chapter_08.code_14.PuzzleNode;
import chapter_08.code_16.ConcurrentPuzzleSolver;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * 程序清单 8-18 在解决器中找不到解答
 */
public class PuzzleSolver<P, M> extends ConcurrentPuzzleSolver<P, M> {

    private final AtomicInteger taskCount = new AtomicInteger(0);

    PuzzleSolver(Puzzle<P, M> puzzle) {
        super(puzzle);
    }

    protected Runnable newTask(P p, M m, PuzzleNode<P, M> n) {
        return new CountingSolverTask(p, m, n);
    }

    class CountingSolverTask extends SolverTask {
        CountingSolverTask(P pos, M move, PuzzleNode<P, M> prev) {
            super(pos, move, prev);
            taskCount.incrementAndGet();
        }

        public void run() {
            try {
                super.run();
            } finally {
                if (taskCount.decrementAndGet() == 0) {
                    solution.setValue(null);
                }
            }
        }
    }
}
