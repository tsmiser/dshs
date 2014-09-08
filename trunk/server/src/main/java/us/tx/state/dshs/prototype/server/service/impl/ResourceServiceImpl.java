package us.tx.state.dshs.prototype.server.service.impl;

import org.springframework.transaction.annotation.Transactional;
import us.tx.state.dshs.prototype.server.dao.BaseDao;
import us.tx.state.dshs.prototype.server.model.BaseModel;
import us.tx.state.dshs.prototype.server.service.ResourceService;

import java.util.Date;

public abstract class ResourceServiceImpl<M extends BaseModel> extends BaseServiceImpl implements ResourceService<M> {
    protected BaseDao<M> dao;

    protected void setBaseDao(BaseDao<M> baseDao) {
        dao = baseDao;
    }

    @Transactional
    @Override
    public M save(M model) {
        model.setModificationTime(new Date());
        if(model.getId()==null) {
            model.setCreationTime(new Date());
        }
        return dao.save(model);
    }


    @Transactional
    @Override
    public void remove(M model) {
        dao.remove(model);
    }

    @Transactional
    @Override
    public void remove(Long id) {
        dao.remove(id);
    }

    @Transactional(readOnly = true)
    @Override
    public M get(Long id) {
        return dao.get(id);
    }
}
