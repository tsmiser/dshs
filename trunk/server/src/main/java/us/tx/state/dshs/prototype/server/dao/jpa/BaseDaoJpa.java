package us.tx.state.dshs.prototype.server.dao.jpa;

import us.tx.state.dshs.prototype.server.dao.BaseDao;
import us.tx.state.dshs.prototype.server.model.BaseModel;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.List;

public abstract class BaseDaoJpa<M extends BaseModel> implements BaseDao<M> {
    @PersistenceContext
    protected EntityManager entityManager;

    @Override
    public M save(M model) {
        entityManager.flush();
        model = entityManager.merge(model);
        return get(model.getId());
    }

    @Override
    public M get(Long id) {
        return (M)entityManager.find(getModelClass(), id);
    }

    @Override
    public M get(String id) {
        return (M)entityManager.find(getModelClass(), id);
    }

    @Override
    public void remove(M model) {
        entityManager.remove(model);
    }


    @Override
    public void remove(Long id) {
        remove(get(id));
    }

    public abstract Class<?> getModelClass();
}
