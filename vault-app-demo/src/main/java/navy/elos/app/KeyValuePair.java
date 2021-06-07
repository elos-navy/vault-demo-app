package navy.elos.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.SequenceGenerator;
import javax.persistence.Id;

@Entity
public class KeyValuePair {
    
    private Long id;
    private String key;
    private String value;

    @Id
    @SequenceGenerator(name = "kvSeq", sequenceName = "kv_id_seq", allocationSize = 1, initialValue = 1)
    @GeneratedValue(generator="kvSeq")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
