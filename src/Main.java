import backup.BackupService;
import tictactoe.Board;
import tictactoe.TicTacToeBackup;

public class Main {
    public static void main(String[] args) {
        BackupService.createBackup("src/directory");


        int[] arrBoard = {0, 1, 2, 1, 0, 3, 2, 1, 0}; // Пример состояния поля
        String filePath = "board_backup.dat"; // Путь к файлу для записи
        Board board = new Board(arrBoard); // Создаем объект доски
        TicTacToeBackup.writeBoardToFile(board, filePath);

    }

}
