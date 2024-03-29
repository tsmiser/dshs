package us.tx.state.dshs.prototype.server.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import us.tx.state.dshs.prototype.server.dao.UserDao;
import us.tx.state.dshs.prototype.server.model.User;
import us.tx.state.dshs.prototype.server.service.UserService;

import java.util.List;

@Service("userService")
public class UserServiceImpl extends ResourceServiceImpl<User> implements UserService {

    @Autowired
    public void setUserDao(UserDao userDao) {
        setBaseDao(userDao);
    }

    @Override
    public List<User> getAll() {
        return ((UserDao)dao).getAll();
    }

}
