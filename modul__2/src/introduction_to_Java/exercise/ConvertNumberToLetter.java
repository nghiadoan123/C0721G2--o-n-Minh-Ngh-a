package introduction_to_Java.exercise;

import java.util.Scanner;

public class ConvertNumberToLetter {
    //   String str;
//   DocSoThanhChu dstc = new DocSoThanhChu();
    //nếu khai báo biens str là kiểu instance thì có thể ko cần gán giá trị
    // lúc này cần new 1 đối tượng mới và gọi tới thuộc tính str
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input your number:");
        int input = sc.nextInt();
        String dataUnit = "";
        String dataDozens = "";
        String datahundres = "";
        if (input >= 0) {
            if (input < 10) {
                int unit = input % 10;
                switch (unit) {
                    case 0:
                        dataUnit = "zero";
                        break;
                    case 1:
                        dataUnit = "one";
                        break;
                    case 2:
                        dataUnit = "two";
                        break;
                    case 3:
                        dataUnit = "three";
                        break;
                    case 4:
                        dataUnit = "four";
                        break;
                    case 5:
                        dataUnit = "five";
                        break;
                    case 6:
                        dataUnit = "six";
                        break;
                    case 7:
                        dataUnit = "seven";
                        break;
                    case 8:
                        dataUnit = "eight";
                        break;
                    case 9:
                        dataUnit = "nine";
                        break;
                }
            } else if (input < 100) {
                int unit = input % 10;
                int dozens = input / 10;
                switch (dozens) {
                    case 1:
                        switch (unit) {
                            case 0:
                                dataUnit = "ten";
                                break;
                            case 1:
                                dataUnit = "eleven";
                                break;
                            case 2:
                                dataUnit = "twelve";
                                break;
                            case 3:
                                dataUnit = "thirteen";
                                break;
                            case 4:
                                dataUnit = "fourteen";
                                break;
                            case 5:
                                dataUnit = "fifteen";
                                break;
                            case 6:
                                dataUnit = "sixteen";
                                break;
                            case 7:
                                dataUnit = "seventeen";
                                break;
                            case 8:
                                dataUnit = "eightteen";
                                break;
                            case 9:
                                dataUnit = "nineteen";
                                break;
                        }
                        break;
                    case 2:
                        dataDozens = "twenty";
                        break;
                    case 3:
                        dataDozens = "thirty";
                        break;
                    case 4:
                        dataDozens = "fourty";
                        break;
                    case 5:
                        dataDozens = "fifty";
                        break;
                    case 6:
                        dataDozens = "sixty";
                        break;
                    case 7:
                        dataDozens = "seventy";
                        break;
                    case 8:
                        dataDozens = "eightty";
                        break;
                    case 9:
                        dataDozens = "ninetty";
                        break;

                }
                switch (unit) {
                    case 0:
                        dataUnit = "";
                        break;
                    case 1:
                        dataUnit = "one";
                        break;
                    case 2:
                        dataUnit = "two";
                        break;
                    case 3:
                        dataUnit = "three";
                        break;
                    case 4:
                        dataUnit = "four";
                        break;
                    case 5:
                        dataUnit = "five";
                        break;
                    case 6:
                        dataUnit = "six";
                        break;
                    case 7:
                        dataUnit = "seven";
                        break;
                    case 8:
                        dataUnit = "eight";
                        break;
                    case 9:
                        dataUnit = "nine";
                        break;
                }

            } else if (input < 1000) {
                int unit = input % 10;
                input = input / 10;
                int dozens = input % 10;
                input = input / 10;
                switch (input) {
                    case 1:
                        datahundres = "one ";
                        break;
                    case 2:
                        datahundres = "two ";
                        break;
                    case 3:
                        datahundres = "three";
                        break;
                    case 4:
                        datahundres = "four";
                        break;
                    case 5:
                        datahundres = "five";
                        break;
                    case 6:
                        datahundres = "six";
                        break;
                    case 7:
                        datahundres = "seven";
                        break;
                    case 8:
                        datahundres = "eight";
                        break;
                    case 9:
                        datahundres = "nine";
                        break;

                }
                switch (dozens) {
                    case 1:
                        switch (unit) {
                            case 0:
                                dataUnit = "ten";
                                break;
                            case 1:
                                dataUnit = "eleven";
                                break;
                            case 2:
                                dataUnit = "twelve";
                                break;
                            case 3:
                                dataUnit = "thirteen";
                                break;
                            case 4:
                                dataUnit = "fourteen";
                                break;
                            case 5:
                                dataUnit = "fifteen";
                                break;
                            case 6:
                                dataUnit = "sixteen";
                                break;
                            case 7:
                                dataUnit = "seventeen";
                                break;
                            case 8:
                                dataUnit = "eightteen";
                                break;
                            case 9:
                                dataUnit = "nineteen";
                                break;
                        }
                        break;
                    case 2:
                        dataDozens = "twenty";
                        break;
                    case 3:
                        dataDozens = "thirty";
                        break;
                    case 4:
                        dataDozens = "fourty";
                        break;
                    case 5:
                        dataDozens = "fifty";
                        break;
                    case 6:
                        dataDozens = "sixty";
                        break;
                    case 7:
                        dataDozens = "seventy";
                        break;
                    case 8:
                        dataDozens = "eightty";
                        break;
                    case 9:
                        dataDozens = "ninetty";
                        break;

                }
                switch (unit) {
                    case 0:
                        dataUnit = "";
                        break;
                    case 1:
                        dataUnit = "one";
                        break;
                    case 2:
                        dataUnit = "two";
                        break;
                    case 3:
                        dataUnit = "three";
                        break;
                    case 4:
                        dataUnit = "four";
                        break;
                    case 5:
                        dataUnit = "five";
                        break;
                    case 6:
                        dataUnit = "six";
                        break;
                    case 7:
                        dataUnit = "seven";
                        break;
                    case 8:
                        dataUnit = "eight";
                        break;
                    case 9:
                        dataUnit = "nine";
                        break;
                }
            }
        }
        System.out.printf("%shundred and %s %s", datahundres, dataDozens, dataUnit);
    }
}

