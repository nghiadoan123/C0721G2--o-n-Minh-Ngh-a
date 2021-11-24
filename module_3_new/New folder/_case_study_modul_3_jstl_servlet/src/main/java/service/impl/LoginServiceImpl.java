package service.impl;

import bean.employee.Login;
import repository.ILoginRepository;
import repository.impl.LoginRepositoryImpl;
import service.ILoginService;

public class LoginServiceImpl implements ILoginService {

    ILoginRepository iLoginRepository = new LoginRepositoryImpl();

    @Override
    public boolean login(Login login) {
        return iLoginRepository.login(login);
    }
}
