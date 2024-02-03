import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;


public class Backup {

    public static void main(String[] args) throws IOException {
        File directory = new File(".");
        File backup = new File("seminar5/backup/");
        backup(directory, backup);
    }

    public static void backup(File directory, File backup) {
        if (!backup.isDirectory()) {
            System.out.println("Переданный путь не директория");
            return;
        }
        if (!directory.isDirectory()) return;
        File[] files = directory.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                try {
                    Files.copy(Path.of(file.getAbsolutePath()), Path.of(backup.getCanonicalPath() + "/"+ file.getName()));
                    System.out.println(file);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
