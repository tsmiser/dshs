package us.tx.state.dshs.prototype.server.dao.jpa;

import org.springframework.stereotype.Repository;
import us.tx.state.dshs.prototype.server.dao.UserDao;
import us.tx.state.dshs.prototype.server.model.User;

import java.util.List;

@Repository("userDao")
public class UserDaoJpa extends BaseDaoJpa<User> implements UserDao {
    @Override
    public Class<?> getModelClass() {
        return User.class;
    }

    @Override
    public List<User> getAll() {
        return entityManager.createQuery("select u from User u").getResultList();
    }
}
