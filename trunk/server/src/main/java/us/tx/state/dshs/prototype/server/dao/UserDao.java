package us.tx.state.dshs.prototype.server.dao;

import us.tx.state.dshs.prototype.server.model.User;

import java.util.List;

public interface UserDao extends BaseDao<User> {
    List<User> getAll();
}
