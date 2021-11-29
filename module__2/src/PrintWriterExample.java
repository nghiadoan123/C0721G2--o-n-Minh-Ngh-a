import java.io.File;
import java.io.PrintWriter;

public class PrintWriterExample {
    public static void main(String[] args) throws Exception {
        // Dữ liệu được ghi trên Console sử dụng lớp PrintWriter
        PrintWriter writer = new PrintWriter(System.out);
        writer.write("VietTuts.Vn: ");
        writer.flush();
        writer.close();
        // Dữ liệu được ghi vào File sử dụng PrintWriter
       // File file = new File("te")
        PrintWriter writer1 = null;
        writer1 = new PrintWriter(new File("D:\\ test out.txt"));
        writer1.write("Java, Spring, Hibernate, Android, PHP, ...");
        writer1.flush();
        writer1.close();
    }
}

