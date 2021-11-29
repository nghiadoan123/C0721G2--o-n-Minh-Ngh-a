package _17_binary_file_and_serialization.exercise.read_product_file;

import java.util.List;
import java.util.Scanner;

public class ProductManager {
    static final String FILE_PATH = "src\\_17_binary_file_and_serialization\\exercise\\read_product_file\\product.txt";

    public static List<Product> productList = ReadAndWriteToCSV.readDataFromFile(FILE_PATH);

    public static Scanner scanner = new Scanner(System.in);

    public void displayProduct() {
        for (Product product : productList) {
            System.out.println(product);
        }
    }

    public void addProduct() {
        System.out.println("enter productId ");
        String id = scanner.next();
        System.out.println("enter productName ");
        String productName = scanner.next();
        System.out.println("enter manufacture ");
        String manufacture = scanner.next();
        System.out.println("enter price ");
        double price = scanner.nextDouble();
        Product product = new Product(id, productName, manufacture, price);
        productList.add(product);
        ReadAndWriteToCSV.writeToFile("src\\_17_binary_file_and_serialization\\exercise\\read_product_file\\product.txt", productList);
    }

    public void search() {
        System.out.println("enter product name");
        String productName = scanner.nextLine();
        for (Product product : productList) {
            if (product.getProductName().equals(productName)) {
                System.out.println(product);
            }
        }
    }
}
