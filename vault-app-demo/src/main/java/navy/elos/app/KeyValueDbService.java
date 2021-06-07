package navy.elos.app;

import java.util.List;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

@ApplicationScoped
public class KeyValueDbService {
    @Inject
    EntityManager em;

    @Transactional
    public List<KeyValuePair> getKeyValueList() {
        return (List<KeyValuePair>) em.createQuery("select a from KeyValuePair a", KeyValuePair.class).getResultList();
    }

    @Transactional
    public void addKeyValuePair(KeyValuePair kvp) {
        KeyValuePair new_kvp = new KeyValuePair();
        new_kvp.setKey(kvp.getKey());
        new_kvp.setValue(kvp.getValue());
        em.persist(new_kvp);
    }
    
}
