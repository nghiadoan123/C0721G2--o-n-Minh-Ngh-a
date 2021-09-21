package services;

import models.Booking;
import models.Contract;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ContactServiceImpl {
    private static Set<Contract> contractList = new TreeSet<>();

    public void createContract(){
        Scanner sc = new Scanner(System.in);
        System.out.println("input contract number:");
        int contractNumber = sc.nextInt();
        System.out.println("input booking number:");
        int bookingNumber = sc.nextInt();
        System.out.println("input deposit:");
        double deposit = sc.nextDouble();
        System.out.println("input totalPayment:");
        double totalPayment = sc.nextDouble();
        System.out.println("input customerId :");
        int customerId = sc.nextInt();
        Contract contract = new Contract(contractNumber,bookingNumber,deposit,totalPayment,customerId);
        contractList.add(contract);
    }

    public void editContract(){
        Scanner sc = new Scanner(System.in);
        System.out.println("input your id customer need to edit:");
        int idCustomer = sc.nextInt();
        for (Contract contract: contractList) {
            if (contract.getCustomerId() == idCustomer){
                System.out.println("input new contract number:");
                int contractNumberNew = sc.nextInt();
                contract.setContractNumber(contractNumberNew);
                System.out.println("input new booking number:");
                int bookingNumberNew = sc.nextInt();
                contract.setBookingNumber(bookingNumberNew);
                System.out.println("input new deposit:");
                double depositNew = sc.nextDouble();
                contract.setDeposit(depositNew);
                System.out.println("input new totalPayment:");
                double totalPaymentNew = sc.nextDouble();
                contract.setTotalPayment(totalPaymentNew);
                contract.setCustomerId(idCustomer);
                //Contract contractNew = new Contract(contractNumberNew,bookingNumberNew,depositNew,totalPaymentNew,contract.getCustomerId());
               // contractList.add(contractNew);
                System.out.println("after edit information");
                displayContractList();
            }else {
                System.out.println("you input id customer not found ");
            }
        }
    }

    public void displayContractList(){
        for (Contract contract: contractList) {
            System.out.println(contract);
        }
    }
}
