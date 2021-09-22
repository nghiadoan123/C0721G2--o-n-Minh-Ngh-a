package _16_io_text_file.exercise.copy_file_text;

import java.util.List;

public class Main {
    public static void main(String[] args) {
        ReadAndCopyFile readAndWriteFile = new ReadAndCopyFile();
        List<String> list = readAndWriteFile.readFile("D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\source file.txt");
        readAndWriteFile.writeFile("D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\targetfile.txt",list);
    }
}
