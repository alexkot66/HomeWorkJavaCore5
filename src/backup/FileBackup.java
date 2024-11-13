package backup;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

public class FileBackup {

    private File file;

    public FileBackup(File file) {
        this.file = file;
    }

    /**
     * Резервное копирование файла в указанную директорию.
     */

    public void backupTo(File backupDirectory) {
        if (file.isFile()) {
            try {
                // Копируем файл в папку резервной копии
                Path sourcePath = file.toPath();
                Path backupPath = backupDirectory.toPath().resolve(file.getName());
                Files.copy(sourcePath, backupPath, StandardCopyOption.REPLACE_EXISTING);
                System.out.println("Скопирован файл: " + file.getName());
            } catch (IOException e) {
                System.err.println("Ошибка при копировании файла: " + file.getName());
                e.printStackTrace();
            }
        }
    }

}
