package teacher_code;


import java.io.File;
import java.io.IOException;
import java.util.Arrays;

public class TeacherCode {
    public static void main(String[] args) throws IOException {
        String path = "basic_programming/lesson_33/src/teacher_code/file.txt";
        String unexistedPath = "basic_programming/lesson_33/src/teacher_code/file_1.txt";
        String dirPath = "basic_programming/lesson_33/src/teacher_code/";
        String unexistedDirPath = "basic_programming/lesson_33/src/teacher_code/files_directory/";

        // абсолютный путь - путь к файлу от вашего компьютера.
        // абсолютный путь актуален в случае, если файл находится за пределами репозитория, в котором происходит
        // разработка
        // /Users/imiftakhov/Desktop/Java/AIT-TR/cohort39.1/basic_programming/lesson_33/src/teacher_code/file.txt

        // в случае, если файл находится в том же репозитории, актуальней взять путь от корня репозитория

        // класс File - описывает объект "файл" в системе jvm
        File file = new File(path);
        File dir = new File(dirPath);

        File unexistedFile = new File(unexistedPath);
        File unexistedDir = new File(unexistedDirPath);

        // метод exists() - проверяет существует ли файл
        System.out.println("file.exists() = " + file.exists());

        // возвращает абсолютный путь до этого файла
        System.out.println("file.getAbsolutePath() = " + file.getAbsolutePath());

        System.out.println("file.length() = " + file.length());

        // два метода проверяющие, что файл является файлом или директорией
        System.out.println("file.isFile() = " + file.isFile());
        System.out.println("file.isDirectory() = " + file.isDirectory());

        System.out.println("dir.isFile() = " + dir.isFile());
        System.out.println("dir.isDirectory() = " + dir.isDirectory());

        // false - если данный файл уже существовал
        System.out.println("file.createNewFile() = " + file.createNewFile());

        // true - если файла не было и мы его создали успешно
        System.out.println("unexistedFile.createNewFile() = " + unexistedFile.createNewFile());

        // true - если файл был удален
        System.out.println("unexistedFile.delete() = " + unexistedFile.delete());

        //  listFiles() - возвращает массив файлов из указанной директориии, либо null
        System.out.println("file.listFiles() = " + file.listFiles());
        System.out.println("dir.listFiles() = " + Arrays.toString(dir.listFiles()));

        // метод для создания директории, которой не существовало
        System.out.println("unexistedDir.mkdir() = " + unexistedDir.mkdir());

        System.out.println("unexistedDir.delete() = " + unexistedDir.delete());

        // повторно создаем удаленный файл, чтобы переименовать:
        unexistedFile.createNewFile();

        // renameTo(File file) - переименовывает существующий файл в файл, указанный в аргументе:
        unexistedFile.renameTo(new File(dirPath + "new_file.pdf"));

        // возвращает время последнего изменения файла в формате количества мс с 00:00:00 1 янв 1970г
        System.out.println("file.lastModified() = " + file.lastModified());

        // данные методы показывают возможность читать указанный файл и записвыть в него новую информацию
        System.out.println("file.canRead() = " + file.canRead());
        System.out.println("file.canWrite() = " + file.canWrite());
    }
}
