package tictactoe;

import java.util.Random;

public class ComputerPlayer implements Player {
    private final Marks mark;
    private Board board;
    private int positiveInfinity = 100;
    private int negativeInfinity = -100;

    public ComputerPlayer(Marks mark, Board board) {
        this.mark = mark;
        this.board = board;
    }

    public final Marks getMark() {
        return this.mark;
    }

    public final int nextMove() {
        double startTime = System.nanoTime();
        int bestPosition = negativeInfinity;
        int bestMoveEvaluated = negativeInfinity;
        int alpha = negativeInfinity;
        int beta = positiveInfinity;
        double duration;

        for (Integer position : board.freePosition()) {
            double startMove = System.nanoTime();
            int valueMove = evaluateMove(board, this.mark, alpha, beta, position, 9, startMove);

            if (valueMove > bestMoveEvaluated) {
                bestMoveEvaluated = valueMove;
                bestPosition = position;
            }

            if (bestMoveEvaluated == 1) {
                return position;
            }

            duration = (System.nanoTime() - startTime) / 1000000000.0;
            if (duration > 2) {
                Random ran = new Random();
                int index = ran.nextInt(board.freePosition().size());
                bestPosition = board.freePosition().get(index);
                break;
            }
        }

        double endTime = System.nanoTime();
        duration = (endTime - startTime) / 1000000000.0;
        System.out.println("Duration: " + duration);
        return bestPosition;
    }

    private int alphaBetaPruning(Board board, Marks currentMark, int alpha, int beta, int depth, double startTime) {
        if (board.win(this.mark)) {
            return 1;
        } else if (board.win(oppositePlayer(this.mark))) {
            return -1;
        } else if (board.tie()) {
            return 0;
        } else if ((System.nanoTime() - startTime) / 1000000000.0 > 0.01) {
            return  -1;
        } else {
            return playAgain(board, currentMark, alpha, beta, depth, startTime);
        }
    }

    private int playAgain(Board board, Marks currentMark, int alpha, int beta, int depth, double startTime) {
        if (minimizingPlayerTurn(currentMark)) {
            return minimizingPlayer(board, currentMark, alpha, beta, depth, startTime);
        } else {
            return maximizingPlayer(board, currentMark, alpha, beta, depth, startTime);
        }
    }

    private boolean minimizingPlayerTurn(Marks currentMark) {
        return currentMark == this.mark;
    }

    private int maximizingPlayer(Board board, Marks currentMark, int alpha, int beta, int depth, double startTime) {
        int maxValue = negativeInfinity;

        if (--depth == 0) {
            return 1;
        }
        for (Integer position : board.freePosition()) {
            int valuePosition = evaluateMove(board, oppositePlayer(currentMark), alpha, beta, position, depth, startTime);
            maxValue = Math.max(valuePosition, maxValue);
            alpha = Math.max(alpha, maxValue);

            if (alpha >= beta) {
                break;
            }
        }

        return maxValue;
    }

    private int minimizingPlayer(Board board, Marks currentMark, int alpha, int beta, int depth, double startTime) {
        int minValue = positiveInfinity;

        if (--depth == 0) {
            return -1;
        }
        for (Integer position : board.freePosition()) {
            int valuePosition = evaluateMove(board, oppositePlayer(currentMark), alpha, beta, position, depth, startTime);
            minValue = Math.min(valuePosition, minValue);
            beta = Math.min(beta, minValue);

            if (alpha >= beta) {
                break;
            }
        }

        return minValue;
    }

    private int evaluateMove(Board board, Marks mark, int alpha, int beta, Integer position, int depth, double startTime) {
        board.putMark(mark, position);
        int valuePosition = alphaBetaPruning(board, mark, alpha, beta, depth, startTime);
        board.removeMark(position);

        return valuePosition;
    }

    private Marks oppositePlayer(Marks mark) {
        if (mark == Marks.CROSS) {
            return Marks.ROUND;
        } else {
            return Marks.CROSS;
        }
    }
}

