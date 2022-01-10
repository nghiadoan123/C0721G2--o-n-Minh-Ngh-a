package com.codegym.case_module_four.model.contract;


import com.codegym.case_module_four.model.customer.Customer;
import com.codegym.case_module_four.model.employee.Employee;
import com.codegym.case_module_four.model.service.Services;

import javax.persistence.*;
import java.util.List;

@Entity
public class Contract {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private int id;
    @Column(name = "check_in",columnDefinition = "DATE")
    private String checkIn;
    @Column(name = "check_out",columnDefinition = "DATE")
    private String checkOut;
    @Column(name = "deposit")
    private int deposit;
    @Column(name = "total_money")
    private int totalMoney;

    @ManyToOne
    @JoinColumn(name = "customer_id",referencedColumnName = "customer_id")
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "employee_id",referencedColumnName = "employee_id")
    private Employee employee;

    @ManyToOne
    @JoinColumn(name = "service_id",referencedColumnName = "service_id")
    private Services services;

    @OneToMany(mappedBy = "contract",cascade = CascadeType.ALL)
    private List<ContractDetail> contractDetails;


    public Contract() {
    }

    public Contract(int id, String checkIn, String checkOut, int deposit, int totalMoney, Customer customer, Employee employee, Services services) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.customer = customer;
        this.employee = employee;
        this.services = services;
    }

    public Contract(int id, String checkIn, String checkOut, int deposit, int totalMoney, Customer customer, Employee employee, Services services, List<ContractDetail> contractDetails) {
        this.id = id;
        this.checkIn = checkIn;
        this.checkOut = checkOut;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.customer = customer;
        this.employee = employee;
        this.services = services;
        this.contractDetails = contractDetails;
    }

    public List<ContractDetail> getContractDetails() {
        return contractDetails;
    }

    public void setContractDetails(List<ContractDetail> contractDetails) {
        this.contractDetails = contractDetails;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCheckIn() {
        return checkIn;
    }

    public void setCheckIn(String checkIn) {
        this.checkIn = checkIn;
    }

    public String getCheckOut() {
        return checkOut;
    }

    public void setCheckOut(String checkOut) {
        this.checkOut = checkOut;
    }

    public int getDeposit() {
        return deposit;
    }

    public void setDeposit(int deposit) {
        this.deposit = deposit;
    }

    public int getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(int totalMoney) {
        this.totalMoney = totalMoney;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Services getServices() {
        return services;
    }

    public void setServices(Services services) {
        this.services = services;
    }
}
