package _16_io_text_file.practice.find_max_value_and_write_in_file;

import java.util.List;

public class FindMaxValue {
    public static int findMax(List<Integer> numbers) {
        int max = numbers.get(0);
        for (int i = 0; i < numbers.size(); i++) {
            if (max < numbers.get(i)) {
                max = numbers.get(i);
            }
        }
        return max;
    }

    public static void main(String[] args) {
        ReadAndWriteFile readAndWriteFile = new ReadAndWriteFile();
        List<Integer> numbers = readAndWriteFile.readFile("D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\numbers.txt");
        int maxValue = findMax(numbers);
        readAndWriteFile.writeFile("D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\modul__2\\result.txt", maxValue );

    }
}
