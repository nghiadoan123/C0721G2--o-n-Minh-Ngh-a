package services;

import models.service.Contract;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ContractServiceImpl implements ContractService {
    private static Set<Contract> contractList = new TreeSet<>();
    @Override
    public void createContract(){
        Scanner sc = new Scanner(System.in);
        System.out.println("input contract number:");
        int contractNumber =Integer.parseInt( sc.nextLine());
        System.out.println("input booking number:");
        int bookingNumber = Integer.parseInt(sc.nextLine());
        System.out.println("input deposit:");
        double deposit = Double.parseDouble(sc.nextLine());
        System.out.println("input totalPayment:");
        double totalPayment = Double.parseDouble(sc.nextLine());
        System.out.println("input customerId :");
        int customerId = Integer.parseInt(sc.nextLine());
        Contract contract = new Contract(contractNumber,bookingNumber,deposit,totalPayment,customerId);
        contractList.add(contract);
    }

    @Override
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
                System.out.println("after edit information");
                displayContractList();
            }else {
                System.out.println("you input id customer not found ");
            }
        }
    }

    @Override
    public void displayContractList(){
        for (Contract contract: contractList) {
            System.out.println(contract);
        }
    }

    @Override
    public void searchContractId() {

    }

    @Override
    public void add() {

    }

    @Override
    public void showList() {

    }

    @Override
    public void search() {

    }

    @Override
    public void delete() {

    }
}
