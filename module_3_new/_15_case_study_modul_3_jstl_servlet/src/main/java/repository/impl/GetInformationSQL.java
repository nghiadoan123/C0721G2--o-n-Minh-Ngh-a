package repository.impl;

import bean.customer.CustomerType;
import bean.employee.Division;
import bean.employee.EducationDegree;
import bean.employee.Position;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class GetInformationSQL {

    public static List<Division> divisionList() {
        List<Division> divisionList = new ArrayList<>();

        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select * from division");
            Division division = null;
            while (resultSet.next()){
                division = new Division();
                division.setId(Integer.parseInt(resultSet.getString("division_id")));
                division.setName(resultSet.getString("division_name"));
                divisionList.add(division);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return divisionList;
    }

    public static List<EducationDegree> educationDegreeList(){
        List<EducationDegree> educationDegreeList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select  * from education_degree");
            EducationDegree educationDegree = null;
            while (resultSet.next()){
                educationDegree = new EducationDegree();
                educationDegree.setId(Integer.parseInt(resultSet.getString("degree_id")));
                educationDegree.setName(resultSet.getString("degree_name"));
                educationDegreeList.add(educationDegree);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return educationDegreeList;
    }

    public static List<Position> positionList(){
        List<Position> positionList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select  * from position");
            Position position = null;
            while (resultSet.next()){
                position = new Position();
                position.setId(Integer.parseInt(resultSet.getString("position_id")));
                position.setName(resultSet.getString("position_name"));
                positionList.add(position);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return positionList;
    }

    public  static List<CustomerType> customerTypeList(){

        List<CustomerType> customerTypeList = new ArrayList<>();
        try {
            Statement statement = BaseRepository.connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select  * from customer_type");
            CustomerType customerType = null;
            while (resultSet.next()){
                customerType = new CustomerType();
                customerType.setId(Integer.parseInt(resultSet.getString("customer_type_id")));
                customerType.setName(resultSet.getString("customer_type_name"));
                customerTypeList.add(customerType);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return customerTypeList;
    }
}
