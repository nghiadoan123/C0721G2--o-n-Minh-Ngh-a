package service.impl;

import bean.service.Service;
import repository.IServiceRepository;
import repository.impl.ServiceRepositoryImpl;
import service.IServiceService;

import java.util.List;
import java.util.Map;

public class ServiceServiceImpl implements IServiceService {
    IServiceRepository iServiceRepository = new ServiceRepositoryImpl();

    @Override
    public List<Service> findAll() {
        return this.iServiceRepository.findAll();
    }

    @Override
    public Map<String, String> save(Service service) {
        return this.iServiceRepository.save(service);
    }

    @Override
    public void remove(int id) {
        this.iServiceRepository.remove(id);
    }

    @Override
    public Service findById(String id) {
        return this.iServiceRepository.findById(id);
    }

    @Override
    public Map<String, String> update(Service service) {
        return this.iServiceRepository.update(service);
    }

    @Override
    public List<Service> findByName(String name) {
        return this.iServiceRepository.findByName(name);
    }
}
