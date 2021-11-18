package repository.impl;

import bean.customer.Customer;
import bean.customer.CustomerType;
import repository.ICustomerRepository;

import java.sql.PreparedStatement;
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
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("insert into customer(customer_id, customer_type_id, customer_name, birthday,gender,id_card,phone,email,address) " +
                            "values(?,?,?,?,?,?,?,?,?)");
            preparedStatement.setInt(1,customer.getId());
            preparedStatement.setInt(2,customer.getCustomerType().getId());
            preparedStatement.setString(3,customer.getName());
            preparedStatement.setString(4,customer.getBirthDay());
            preparedStatement.setString(5,customer.getGender());
            preparedStatement.setString(6,customer.getIdCard());
            preparedStatement.setString(7,customer.getPhone());
            preparedStatement.setString(8,customer.getEmail());
            preparedStatement.setString(9,customer.getAddress());
            preparedStatement.executeLargeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void remove(int id) {
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("delete from customer where customer_id = ?");
            preparedStatement.setInt(1,id);
            preparedStatement.executeUpdate();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public Customer findById(int id) {
        List<Customer> customerList = findAll();
        Customer customer = null;
        for (Customer customer1: customerList) {
            if (customer1.getId() == id){
                customer = customer1;
            }
        }
        return customer;
    }

    @Override
    public void update(Customer customer) {
        try {
            PreparedStatement preparedStatement =
                    BaseRepository.connection.prepareStatement("update customer , customer_type_id=?,customer_name=?," +
                            "birthday=?,id_card=?,phone=?,email=?,address=? where customer_id=?");


            preparedStatement.setInt(1,customer.getCustomerType().getId());
            preparedStatement.setString(2,customer.getName());
            preparedStatement.setString(3,customer.getBirthDay());
            preparedStatement.setString(4,customer.getGender());
            preparedStatement.setString(5,customer.getIdCard());
            preparedStatement.setString(6,customer.getPhone());
            preparedStatement.setString(7,customer.getEmail());
            preparedStatement.setString(8,customer.getAddress());
            preparedStatement.setInt(9,customer.getId());
            preparedStatement.executeLargeUpdate();


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public List<Customer> findByName(String name) {
        List<Customer> customerList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("select * from customer "
                    + "where customer_name= ?");
            preparedStatement.setString(1,name);
            ResultSet resultSet = preparedStatement.executeQuery();

            Customer customer = null;
            CustomerType customerType = null;
            while (resultSet.next()){
                customerType = new CustomerType();
                customer = new Customer();
                customer.setId(Integer.parseInt(resultSet.getString("customer_id")));
                customer.setName(resultSet.getString("customer_name"));
                customer.setBirthDay(resultSet.getString("birthday"));
                customer.setGender(resultSet.getString("gender"));
                customer.setIdCard(resultSet.getString("id_card"));
                customer.setPhone(resultSet.getString("phone"));
                customer.setEmail(resultSet.getString("email"));
                customer.setAddress(resultSet.getString("address"));


                customerType.setId(Integer.parseInt(resultSet.getString("customer_type_id")));
                customer.setCustomerType(customerType);
                customerList.add(customer);

            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerList;
    }
}
