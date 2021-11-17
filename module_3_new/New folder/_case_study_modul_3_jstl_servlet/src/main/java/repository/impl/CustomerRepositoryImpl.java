package repository.impl;

import bean.customer.Customer;
import bean.customer.CustomerType;
import repository.ICustomerRepository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl implements ICustomerRepository {

    @Override
    public List<Customer> findAll() {
        List<Customer> customerList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from customer");
            Customer customer = null;
            CustomerType customerType = null;
            while (resultSet.next()){
                customer = new Customer();
                customerType = new CustomerType();
                customer.setId(Integer.parseInt(resultSet.getString("customer_id")));
                customerType.setId(Integer.parseInt(resultSet.getString("customer_type_id")));
                customer.setName(resultSet.getString("customer_name"));
                customer.setBirthDay(resultSet.getString("birthday"));
                customer.setGender(resultSet.getString("gender"));
                customer.setIdCard(resultSet.getString("id_card"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setAddress(resultSet.getString("address"));
                customer.setCustomerType(customerType);

                customerList.add(customer);

            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }

    @Override
    public void save(Customer customer) {

    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Customer findById(int id) {
        return null;
    }

    @Override
    public void update(Customer employee) {

    }

    @Override
    public List<Customer> findByName(String name) {
        return null;
    }
}
