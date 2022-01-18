package com.codegym.management.model;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.*;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

@Entity(name = "contract")
public class Contract implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contract_id")
    private int id;
    @Column(name = "day_buy")
    @NotBlank(message = "not blank")

    private String dayBuy;
    @Min(value = 1,message = "quantity must be larger than 0")
    @Max(value = 100,message = "quantity must be les than 100")
    @Column(name = "quantity")
    private int quantity;

    @ManyToOne
    @JoinColumn(name = "product_id", referencedColumnName = "product_id")
    private Product product;


    public Contract() {
    }

    public Contract(int id, String dayBuy, int quantity, Product product) {
        this.id = id;
        this.dayBuy = dayBuy;
        this.quantity = quantity;
        this.product = product;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDayBuy() {
        return dayBuy;
    }

    public void setDayBuy(String dayBuy) {
        this.dayBuy = dayBuy;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

        Contract contract = (Contract) target;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date birth = simpleDateFormat.parse(contract.getDayBuy());
            int yearOld = LocalDate.now().getYear() - birth.getYear() - 1900;
            int month = LocalDate.now().getMonthValue() - birth.getMonth() - 1;
            int day = LocalDate.now().getDayOfYear() - birth.getDate();

            System.out.println(yearOld);
            System.out.println(day);
            if (!(yearOld>0)) {

                errors.rejectValue("dayBuy", "birthDay.lessthan18");
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
