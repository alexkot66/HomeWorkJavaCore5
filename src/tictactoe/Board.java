package tictactoe;

public class Board {

    private int[] board;

    /**
     * Конструктор для создания объекта Board.
     */
    public Board(int[] board) {
        if (board.length != 9) {
            throw new IllegalArgumentException("Доска должна состоять из 9 элементов.");
        }

        for (int i = 0; i < board.length; i++){
            if(board[i] > 3 || board[i] < 0){
                throw new IllegalArgumentException("Доска должна состоять из состояний 0, 1, 2, 3");
            }
        }

        this.board = board;
    }

    /**
     * Геттер для получения состояния доски.
     */
    public int[] getBoard() {
        return board;
    }

}
