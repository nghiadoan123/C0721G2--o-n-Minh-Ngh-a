package services;

import models.person.Customer;
import models.service.contract.Contract;
import utils.ContractReadAndWriteFileToCSV;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ContractServiceImpl implements ContractService {
    public static final String FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\furama_resort\\src\\data\\contract.csv";
    private static TreeSet<Contract> contractList = ContractReadAndWriteFileToCSV.readListBookingFromCSV(FILE_PATH);
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
        String customerId = sc.nextLine();
        Customer customer = CustomerServiceImpl.setCustomer(customerId);
        Contract contract = new Contract(contractNumber,bookingNumber,deposit,totalPayment,customer);
        contractList.add(contract);
        ContractReadAndWriteFileToCSV.writeListBookingToCSV(contractList,FILE_PATH,false);
    }

    @Override
    public void editContract(){
        Scanner sc = new Scanner(System.in);
        System.out.println("input your id customer need to edit:");
        String idCustomer = sc.nextLine();
        for (Contract contract: contractList) {
            System.out.println(contract.getCustomer().getId());
            if (contract.getCustomer().getId().compareTo(idCustomer) ==0){
                System.out.println("input new contract number:");
                int contractNumberNew = Integer.parseInt(sc.nextLine());
                contract.setContractNumber(contractNumberNew);
                System.out.println("input new booking number:");
                int bookingNumberNew =  Integer.parseInt(sc.nextLine());
                contract.setBookingNumber(bookingNumberNew);
                System.out.println("input new deposit:");
                double depositNew = Double.parseDouble(sc.nextLine());
                contract.setDeposit(depositNew);
                System.out.println("input new totalPayment:");
                double totalPaymentNew = Double.parseDouble(sc.nextLine());
                contract.setTotalPayment(totalPaymentNew);
                contract.getCustomer().setId(idCustomer);
                System.out.println("after edit information");
                displayContractList();
            }else {
                System.out.println("you input id customer not found ");
            }
        }
        ContractReadAndWriteFileToCSV.writeListBookingToCSV(contractList,FILE_PATH,false);
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
