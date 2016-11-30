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
        int bestPosition = negativeInfinity;
        int bestMoveEvaluated = negativeInfinity;
        int alpha = negativeInfinity;
        int beta = positiveInfinity;
        int depth = 40;

        for (Integer position : board.freePosition()) {
            int valueMove = evaluateMove(board, this.mark, alpha, beta, position, depth, System.nanoTime());

            if (valueMove > bestMoveEvaluated) {
                bestMoveEvaluated = valueMove;
                bestPosition = position;
            }

            if (perfectMoveFound(bestMoveEvaluated)) {
                break;
            }

        }

        if (!couldEvaluateMove(bestMoveEvaluated)) {
            return randomMove();
        } else {
            return bestPosition;
        }
    }

    private boolean perfectMoveFound(int bestMoveEvaluated) {
        return bestMoveEvaluated == 1;
    }

    private boolean couldEvaluateMove(int bestMoveEvaluated) {
        return bestMoveEvaluated != -2;
    }

    private int randomMove() {
        int index = new Random().nextInt(board.freePosition().size());
        return board.freePosition().get(index);
    }

    private final double LIMIT_SECONDS_FOUND_MOVE = 0.1;
    private int alphaBetaPruning(Board board, Marks currentMark, int alpha, int beta, int depth, double startTime) {
        if (board.win(this.mark)) {
            return 1;
        } else if (board.win(oppositePlayer(this.mark))) {
            return -1;
        } else if (board.tie()) {
            return 0;
        } else if (timeSpent(startTime) > LIMIT_SECONDS_FOUND_MOVE) {
            return  -2;
        } else {
            return playAgain(board, currentMark, alpha, beta, depth, startTime);
        }
    }

    private double timeSpent(double startTime) {
        return (System.nanoTime() - startTime) / 1000000000.0;
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

