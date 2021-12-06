package repository.impl;

import bean.service.RentalType;
import bean.service.Service;
import bean.service.ServiceType;
import repository.IServiceRepository;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class ServiceRepositoryImpl implements IServiceRepository {
    @Override
    public List<Service> findAll() {
        List<Service> serviceList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = BaseRepository.connection.prepareStatement("select * from service");
            ResultSet resultSet = preparedStatement.executeQuery();
            Service service = null;
            RentalType rentalType = null;
            ServiceType serviceType = null;
            while (resultSet.next()){
                service = new Service();
                rentalType = new RentalType();
                serviceType = new ServiceType();
                service.setId(Integer.parseInt(resultSet.getString("service_id")));
                service.setName(resultSet.getString("service_name"));
                service.setArea(Integer.parseInt(resultSet.getString("area")));
                service.setCost(Integer.parseInt(resultSet.getString("cost")));
                service.setNumberOfPerson(Integer.parseInt(resultSet.getString("number_of_person")));
                service.setStandardRoom(resultSet.getString("standard_room"));
                service.setDescription(resultSet.getString("description_other_convenience"));



                rentalType.setId(Integer.parseInt(resultSet.getString("rental_type_id")));
                serviceType.setId(Integer.parseInt(resultSet.getString("service_type_id")));

                service.setRentalType(rentalType);
                service.setServiceType(serviceType);
                service.setPoolArea(Integer.parseInt(resultSet.getString("area_pool")));
                service.setNumberOfFloor(Integer.parseInt(resultSet.getString("number_of_floors")));
                serviceList.add(service);
            }

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public Map<String, String> save(Service service) {
        return null;
    }

    @Override
    public void remove(int id) {

    }

    @Override
    public Service findById(String id) {
        return null;
    }

    @Override
    public Map<String, String> update(Service service) {
        return null;
    }

    @Override
    public List<Service> findByName(String name) {
        return null;
    }
}
