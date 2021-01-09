package br.com.greatsoft.greaterp.model.entity.finnance;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(
        name = "SEQ_ACCGROUP",
        sequenceName = "SEQ_ACCGROUP",
        allocationSize = 0,
        initialValue = 1
)
public class AccountingGroup implements Serializable {
    @Id
    @GeneratedValue(
            generator = "SEQ_ACCGROUP",
            strategy = GenerationType.SEQUENCE
    )
    private long id;
    private String description;
    private String nature;

    public AccountingGroup() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNature() {
        return this.nature;
    }

    public void setNature(String nature) {
        this.nature = nature;
    }
}
