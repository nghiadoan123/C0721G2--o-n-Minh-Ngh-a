package com.codegym.demo.util;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.service.ServiceRegistry;
import org.hibernate.type.Type;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class StudentIdGenerator implements IdentifierGenerator {

    private String prefix = "";
    @Override
    public Serializable generate(SharedSessionContractImplementor session, Object object) throws HibernateException {
        prefix = "student";
        Connection connection = session.connection();
        Statement statement = null;

        try {

            statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("select id as id from student order by id desc ");
            if (resultSet.next()){
                String id = resultSet.getString(1);
                String arr[] = id.split("_");
                int temp = Integer.parseInt(arr[1]);
                String generatedId = prefix+ "_" + (temp+1);
                return generatedId;
            }else {
                return "student_0";
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }


    @Override
    public void configure(Type type, Properties properties,
                          ServiceRegistry serviceRegistry) throws MappingException {

        prefix = properties.getProperty("prefix");

    }
}
