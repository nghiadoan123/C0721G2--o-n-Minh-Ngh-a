package _12_java_collection_framework.exercise.product_manager;


import _12_java_collection_framework.practice.sort_with_comparable_and_comparator.Student;

import java.util.*;

public class ManagerProduct {
    List<Product> productLists = new ArrayList<>();

    public void addProduct() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập id:");
        int id = sc.nextInt();
        System.out.println("Nhập tên product:");
        String productName = sc.next();
        System.out.println("Nhập mổ tả sản phẩm:");
        String description = sc.next();
        System.out.println("Nhập giá sản phẩm:");
        double price = sc.nextDouble();
        System.out.println();
        Product product = new Product(id, productName, description, price);
        productLists.add(product);
    }

    public void editProduct() {
        showProduct();
        System.out.println("nhập vào id của sản phẩm cần edit");
        Scanner sc = new Scanner(System.in);
        int chooseId = sc.nextInt();
        System.out.println("nhập vào tên sản phẩm cần sưa");
        productLists.get(chooseId - 1).setProductName(sc.next());
        System.out.println("nhập vào miêu tả sản phẩm ");
        productLists.get(chooseId - 1).setDescriptionProduct(sc.next());
        System.out.println("nhập vào giá sản phẩm ");
        productLists.get(chooseId - 1).setPrice(sc.nextDouble());
        showProduct();
    }
    // c1
    public void sortUpPrice(){
        SortUpPrice sortUpPrice = new SortUpPrice();
        Collections.sort(productLists,sortUpPrice);
        for(Product product : productLists){
            System.out.println(product.toString());
        }
    }

    public void sortDownPrice(){
        SortDownPrice sortDownPrice = new SortDownPrice();
        Collections.sort(productLists,sortDownPrice);
        for (Product product: productLists) {
            System.out.println(product.toString());
        }
    }
    //c2
//    public void sortUpPrice() {
//        //showProduct();
//        Collections.sort(productLists, new Comparator<Product>() {
//            @Override
//            public int compare(Product product1, Product product2) {
//                if (product1.getPrice()>product2.getPrice()){
//                    return 1;
//                }else if (product1.getPrice()<product2.getPrice()){
//                    return -1;
//                }else {
//                    return 0;
//                }
//            }
//        });
//        for(Product product : productLists){
//            System.out.println(product.toString());
//        }
//    }
//
//    public void sortDownPrice() {
//        Collections.sort(productLists, (product1, product2) -> {
//            if (product1.getPrice()>product2.getPrice()){
//                return -1;
//            }else if (product1.getPrice()<product2.getPrice()){
//                return 1;
//            }else {
//                return 0;
//            }
//        });
//        for(Product product : productLists){
//            System.out.println(product.toString());
//        }
//    }

    public void deleteProduct() {
        showProduct();
        System.out.println("nhập vào id của sản phẩm cần xóa");
        Scanner sc = new Scanner(System.in);
        int chooseId = sc.nextInt();
        productLists.remove(chooseId - 1);
        System.out.println("danh sách sau khi xóa");
        showProduct();
    }

    public void searchProduct() {
        showProduct();
        System.out.println("nhập vào id của sản phẩm cần tìm");
        Scanner sc = new Scanner(System.in);
        int chooseId = sc.nextInt();
        System.out.println("thông tin sản phẩm cần tìm");
        System.out.println(productLists.get(chooseId - 1));
    }

    public void showProduct() {
        for (int i = 0; i < productLists.size(); i++) {
            System.out.println(productLists.get(i));
        }
    }
}
