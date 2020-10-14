package chapter_08.code_16;

import chapter_08.code_13.Puzzle;
import chapter_08.code_14.PuzzleNode;
import chapter_08.code_17.ValueLatch;

import java.util.List;
import java.util.concurrent.*;

/**
 * 程序清单 8-16 并发的谜题解答器
 */
public class ConcurrentPuzzleSolver<P, M> {
    private final Puzzle<P, M> puzzle;
    private final ExecutorService exec = Executors.newCachedThreadPool();
    private final ConcurrentMap<P, Boolean> seen = new ConcurrentHashMap<>();
    protected final ValueLatch<PuzzleNode<P, M>> solution = new ValueLatch<>();

    public ConcurrentPuzzleSolver(Puzzle<P, M> puzzle) {
        this.puzzle = puzzle;
        if (exec instanceof ThreadPoolExecutor) {
            ThreadPoolExecutor tpe = (ThreadPoolExecutor) exec;
            tpe.setRejectedExecutionHandler(new ThreadPoolExecutor.DiscardPolicy());
        }
    }

    public List<M> solve() throws InterruptedException {
        try {
            P p = puzzle.initialPosition();
            exec.execute(newTask(p, null, null));
            // 阻塞直到找到解答
            PuzzleNode<P, M> solutionPuzzleNode = solution.getValue();
            return solutionPuzzleNode == null ? null : solutionPuzzleNode.asMoveList();
        } finally {
            exec.shutdown();
        }
    }

    private Runnable newTask(P p, M m, PuzzleNode<P, M> n) {
        return new SolverTask(p, m, n);
    }

    protected class SolverTask extends PuzzleNode<P, M> implements Runnable {
        protected SolverTask(P pos, M move, PuzzleNode<P, M> prev) {
            super(pos, move, prev);
        }

        public void run() {
            if (solution.isSet()
                    || seen.putIfAbsent(getPos(), true) != null) {
                // 已经找到了解答或者已经遍历了这个位置
                return;
            }
            if (puzzle.isGoal(getPos())) {
                solution.setValue(this);
            } else {
                for (M m : puzzle.legalMoves(getPos())) {
                    exec.execute(newTask(puzzle.move(getPos(), getMove()), getMove(), this));
                }
            }
        }
    }
}
