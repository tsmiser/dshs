package us.tx.state.dshs.prototype.server.dao;

import us.tx.state.dshs.prototype.server.model.BaseModel;

public interface BaseDao<M extends BaseModel> {
    M save(M model);

    M get(Long id);

    M get(String id);

    void remove(M model);

    void remove(Long id);
}
