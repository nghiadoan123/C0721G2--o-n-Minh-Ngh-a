package services;

import models.person.Customer;
import models.service.booking.Booking;
import models.service.contract.Contract;
import utils.BookingReadAndWriteFileToCSV;
import utils.ContractReadAndWriteFileToCSV;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class ContractServiceImpl implements ContractService {
    public static final String BOOKING_FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\furama_resort\\src\\data\\booking.csv";
    public static final String FILE_PATH = "D:\\first\\module1-6\\C0721G2--o-n-Minh-Ngh-a\\furama_resort\\src\\data\\contract.csv";
    public static TreeSet<Contract> contractList = ContractReadAndWriteFileToCSV.readListContractFromCSV(FILE_PATH);

    @Override
    public void createContract() throws Exception {
        try {
            System.out.println(BookingServiceImpl.bookingList.first());
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
            Customer customer = inputCustomer();
            BookingServiceImpl.bookingList.pollFirst();
            Contract contract = new Contract(contractNumber,bookingNumber,deposit,totalPayment,customer);
            contractList.add(contract);
            ContractReadAndWriteFileToCSV.writeListContractToCSV(contractList,FILE_PATH,false);
            BookingReadAndWriteFileToCSV.writeToFile(BookingServiceImpl.bookingList,BOOKING_FILE_PATH);

        }catch (Exception e){
            System.out.println("need booking first");
        }

    }

    public static Customer inputCustomer() throws Exception {
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("Enter customer ID");
            String customerID = scanner.nextLine();
            for (Customer customer: CustomerServiceImpl.customerList) {
                if (customerID.equals(customer.getId())){
                    return customer;
                }
            }
            System.out.println("not found");
            return null;
        }

    }

    @Override
    public void editContract(){
        Scanner sc = new Scanner(System.in);
        System.out.println("input your id customer need to edit:");
        String idCustomer = sc.nextLine();
        boolean flag = true;
        for (Contract contract: contractList) {
            if (contract.getCustomer().getId().equals(idCustomer)){
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
                flag = false;
            }
        }
        if (!flag){
            System.out.println("not found");
        }
        ContractReadAndWriteFileToCSV.writeListContractToCSV(contractList,FILE_PATH,false);
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


}
