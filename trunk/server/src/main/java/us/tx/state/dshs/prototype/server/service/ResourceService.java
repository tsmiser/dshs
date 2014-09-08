package us.tx.state.dshs.prototype.server.service;

import org.springframework.transaction.annotation.Transactional;
import us.tx.state.dshs.prototype.server.model.BaseModel;

public interface ResourceService<M extends BaseModel> extends BaseService {
    @Transactional
    M save(M model);

    @Transactional
    void remove(M model);

    @Transactional
    void remove(Long id);

    @Transactional(readOnly = true)
    M get(Long id);
}
