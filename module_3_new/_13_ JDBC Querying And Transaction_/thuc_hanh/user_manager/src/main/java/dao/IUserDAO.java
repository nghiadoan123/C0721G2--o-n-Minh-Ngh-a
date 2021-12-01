package dao;

import model.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserDAO {
    void insertUser(User user) throws SQLException;

    User selectUser(int id);

    List<User> selectAllUsers();

    List<User> selectAllUserStore();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    User getUserById(int id);// thục hành 1

    void insertUserStore(User user) throws SQLException;// thực hành 1

    void addUserTransaction(User user, int[] permission);//Thuc hanh 2

    void insertUpdateWithoutTransaction();//thuc hanh 3

    public void insertUpdateUseTransaction(); //thuc hanh4
}
