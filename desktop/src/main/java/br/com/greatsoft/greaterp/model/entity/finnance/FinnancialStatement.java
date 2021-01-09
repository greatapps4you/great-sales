package br.com.greatsoft.greaterp.model.entity.finnance;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@SequenceGenerator(
        name = "SEQ_FINNANSTAT",
        sequenceName = "SEQ_FINNANSTAT",
        allocationSize = 0,
        initialValue = 1
)
public class FinnancialStatement implements Serializable {
    @Id
    @GeneratedValue(
            generator = "SEQ_FINNANSTAT",
            strategy = GenerationType.SEQUENCE
    )
    private long id;
    @OneToMany(
            fetch = FetchType.EAGER
    )
    @Cascade({CascadeType.ALL})
    @Fetch(FetchMode.SELECT)
    private List<AccountingRecord> records;

    public FinnancialStatement() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<AccountingRecord> getRecords() {
        return this.records;
    }

    public void setRecords(List<AccountingRecord> records) {
        this.records = records;
    }
}
