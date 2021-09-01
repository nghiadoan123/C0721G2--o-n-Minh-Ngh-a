package loop_in_java.exercise;

import java.util.Scanner;

public class DrawTypePicture {
    public static void main(String[] args) {
        int choose = -1;
        Scanner sc = new Scanner(System.in);
        while (choose != 0){
            System.out.println("Menu");
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle");
            System.out.println("3. Print isosceles triangle");
            System.out.println("4. Exit");
            System.out.println("Enter your choice: ");
            choose = sc.nextInt();
            switch (choose){
                case 1:
                    System.out.println("input row:");
                    int row = sc.nextInt();
                    System.out.println("input col");
                    int col = sc.nextInt();
                    for (int i =0;i<row;i++){
                        for (int j =0;j<col;j++){
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;
                case 2:
                    System.out.println("choose your type");
                    System.out.println("Menu");
                    System.out.println("1. Print top left triangle");
                    System.out.println("2. Print top right triangle");
                    System.out.println("3. Print bottom left triangle");
                    System.out.println("4. Print bottom right triangle");
                    System.out.println("5. Exit");
                    int chooseType = sc.nextInt();
                    switch (chooseType){
                        case 1:
                            System.out.println("input n:");
                            int input1 = sc.nextInt();
                            int n = input1;
                            for (int i=0;i<input1;i++){
                                for (int j =0;j<n;j++){
                                    System.out.print("*");
                                }
                                System.out.println();
                                n--;
                            }
                            break;
                        case 2:
                            System.out.println("input n:");
                            int input2 = sc.nextInt();
                            int n1 = input2;
                            int m1 = 0;
                            for (int i =0;i<input2;i++){
                                for (int k =0;k<m1;k++){
                                    System.out.print(" ");
                                }
                                m1++;
                                for (int j =0;j<n1;j++){
                                    System.out.print("*");
                                }
                                n1--;
                                System.out.println();
                            }
                            break;
                        case 3:
                            System.out.println("input n:");
                            int input3 = sc.nextInt();
                            for (int i=0;i<input3;i++){
                                for (int j = i+1;j>0;j--){
                                    System.out.print("* ");
                                }
                                System.out.println();
                            }
                            break;
                        case 4:
                            System.out.println("input n:");
                            int input4 = sc.nextInt();
                            int n4 = input4-1;
                            int m4 =1;
                            for (int i =0;i<input4;i++){
                                for (int j =0;j<n4;j++){
                                    System.out.print(" ");
                                }
                                n4--;
                                for (int j=0;j<m4;j++){
                                    System.out.print("*");
                                }
                                m4++;
                                System.out.println();
                            }
                            break;
                        case 5:
                            break;
                    }
                    break;
                case 3:
                    System.out.println("input height of isoscele triangle");
                    int height = sc.nextInt();
                    int n = height-1;
                    int m = 1;
                    for (int i =0;i<height;i++){
                        for (int j=0;j<n;j++){
                            System.out.print(" ");
                        }
                        n--;
                        for (int k =0;k<m;k++){
                            System.out.print("* ");
                        }
                        m++;
                        System.out.println();
                    }
                    break;
                case 4:
                    System.exit(0);
                    break;
            }
        }
    }
}
