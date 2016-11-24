package tictactoe;

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

        for (Integer position : board.freePosition()) {
            int valueMove = evaluateMove(board, this.mark, alpha, beta, position);

            if (valueMove > bestMoveEvaluated) {
                bestMoveEvaluated = valueMove;
                bestPosition = position;
            }
        }

        return bestPosition;
    }

    private int alphaBetaPruning(Board board, Marks currentMark, int alpha, int beta) {
        if (board.win(this.mark)) {
            return 1;
        } else if (board.win(oppositePlayer(this.mark))) {
            return -1;
        } else if (board.tie()) {
            return 0;
        } else {
            return playAgain(board, currentMark, alpha, beta);
        }
    }

    private int playAgain(Board board, Marks currentMark, int alpha, int beta) {
        if (minimizingPlayerTurn(currentMark)) {
            return minimizingPlayer(board, currentMark, alpha, beta);
        } else {
            return maximizingPlayer(board, currentMark, alpha, beta);
        }
    }

    private boolean minimizingPlayerTurn(Marks currentMark) {
        return currentMark == this.mark;
    }

    private int maximizingPlayer(Board board, Marks currentMark, int alpha, int beta) {
        int maxValue = negativeInfinity;

        for (Integer position : board.freePosition()) {
            int valuePosition = evaluateMove(board, oppositePlayer(currentMark), alpha, beta, position);
            maxValue = Math.max(valuePosition, maxValue);
            alpha = Math.max(alpha, maxValue);

            if (beta <= alpha) {
                break;
            }
        }

        return maxValue;
    }

    private int minimizingPlayer(Board board, Marks currentMark, int alpha, int beta) {
        int minValue = positiveInfinity;

        for (Integer position : board.freePosition()) {
            int valuePosition = evaluateMove(board, oppositePlayer(currentMark), alpha, beta, position);
            minValue = Math.min(valuePosition, minValue);
            beta = Math.max(beta, minValue);

            if (beta <= alpha) {
                break;
            }
        }

        return minValue;
    }

    private int evaluateMove(Board board, Marks mark, int alpha, int beta, Integer position) {
        board.putMark(mark, position);
        int valuePosition = alphaBetaPruning(board, mark, alpha, beta);
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
