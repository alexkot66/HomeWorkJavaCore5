package tictactoe;

import java.io.FileOutputStream;
import java.io.IOException;

public class TicTacToeBackup {

    /**
     * Сохраняет состояние доски в указанный файл.
     */
    public static void writeBoardToFile(Board board, String filename) {
        int[] arrboard = board.getBoard();

        // Преобразуем массив в 3 байта
        byte[] bytes = new byte[3];
        for (int i = 0; i < 9; i++) {
            // Записываем значения в соответствующие биты
            int byteIndex = i / 3; // Индекс байта (0, 1, или 2)
            int bitIndex = i % 3; // Индекс бита (0, 1, или 2)
            bytes[byteIndex] |= (byte) ((arrboard[i] & 0x03) << (bitIndex * 2)); // Сдвигаем значение на 2 бита
        }

        /*
        Оператор & используется для побитового И с маской 0x03 (которая в двоичном представлении равна 00000011).
        Это гарантирует, что мы получаем только последние два бита значения board[i].
        Таким образом, если board[i] равно 2, результат будет 2 (в двоичном: 10), а если 3, то результат будет 3 (в двоичном: 11).
         */

        try (FileOutputStream fos = new FileOutputStream(filename)) {
                fos.write(bytes);
            System.out.println("Данные записаны в файл " + filename);
        } catch (IOException e) {
            System.out.println("Ошибка при записи в файл.");
            e.printStackTrace();
        }
    }
}
