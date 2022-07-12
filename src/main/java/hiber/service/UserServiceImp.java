package hiber.service;

import hiber.dao.UserDao;
import hiber.model.User;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class UserServiceImp implements UserService {

    private final UserDao userDao;

    public UserServiceImp(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void addUser(User user) {
        userDao.addUser(user);
    }
    @Override
    public List<User> listUsers() {
        return userDao.listUsers();
    }
    @Override
    public User getUserByCar(String model, int series) {
        return userDao.getUserByCar(model, series);
    }

}
