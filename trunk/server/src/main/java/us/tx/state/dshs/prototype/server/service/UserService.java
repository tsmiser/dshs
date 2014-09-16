package us.tx.state.dshs.prototype.server.service;

import us.tx.state.dshs.prototype.server.model.User;

import java.util.List;

public interface UserService extends ResourceService<User> {
    List<User> getAll();
}
