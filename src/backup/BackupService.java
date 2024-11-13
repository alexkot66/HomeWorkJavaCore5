package backup;

import java.io.File;

public class BackupService {

    /**
     * В указанной директории создает резервные копии всех файлов.
     */
    public static void createBackup(String sourceDir) {
        File sourceDirectory = new File(sourceDir);
        File backupDirectory = new File("./backup");

        // Создаем папку для бэкапов, если она не существует
        if (!backupDirectory.exists()) {
            backupDirectory.mkdir();
        }

        // Перебираем массив файлов в исходной директории
        File[] files = sourceDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                FileBackup fileBackup = new FileBackup(file);
                fileBackup.backupTo(backupDirectory); // Копируем файл в папку ./backup
            }
        } else {
            System.out.println("Ошибка: Директория не найдена или пуста.");
        }
    }
}
