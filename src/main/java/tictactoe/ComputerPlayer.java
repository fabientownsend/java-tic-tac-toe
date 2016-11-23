package tictactoe;

public class ComputerPlayer implements Player {
    private Marks mark;
    private Board board;

    public ComputerPlayer(Marks mark, Board board) {
        this.mark = mark;
        this.board = board;
    }

    public Marks getMark() {
        return this.mark;
    }

    public int nextMove() {
        return bestMove();
    }

    public int bestMove() {
        int bestMove = -100;
        int bestValue = -100;
        int alpha = -100;
        int beta = 100;

        for (Integer position : board.freePosition()) {
            board.putMark(this.mark, position);
            int result = minimax(board, this.mark, alpha, beta);
            board.removeMark(position);
            if (result > bestValue) {
                bestValue = result;
                bestMove = position;
            }
        }
        return bestMove;
    }

    private int minimax(Board board, Marks currentMark, int alpha, int beta) {
        if (board.win(this.mark)) {
            return 1;
        } else if (board.win(oppositePlayer(this.mark))) {
            return -1;
        } else if (board.tie()) {
            return 0;
        } else {
            if (currentMark == this.mark) {
                int min_value = 100;
                for (Integer i : board.freePosition()) {
                    board.putMark(oppositePlayer(currentMark), i);
                    int value = minimax(board, oppositePlayer(currentMark), alpha, beta);
                    board.removeMark(i);
                    min_value = Math.min(value, min_value);
                    beta = Math.max(beta, min_value);
                    if (beta <= alpha) {
                        break;
                    }
                }
                return min_value;
            } else {
                int max_value = -100;
                for (Integer i : board.freePosition()) {
                    board.putMark(oppositePlayer(currentMark), i);
                    int value = minimax(board, oppositePlayer(currentMark), alpha, beta);
                    board.removeMark(i);
                    max_value = Math.max(value, max_value);
                    alpha = Math.max(alpha, max_value);
                    if (beta <= alpha) {
                        break;
                    }
                }
                return max_value;
            }
        }
    }

    private Marks oppositePlayer(Marks mark) {
        if (mark == Marks.CROSS) {
            return Marks.ROUND;
        } else {
            return Marks.CROSS;
        }
    }
}
