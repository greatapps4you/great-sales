package br.com.greatsoft.greaterp.model.entity.finnance;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@SequenceGenerator(
        name = "SEQ_ACCRECORD",
        sequenceName = "SEQ_ACCRECORD",
        allocationSize = 0,
        initialValue = 1
)
public class AccountingRecord implements Serializable {
    @Id
    @GeneratedValue(
            generator = "SEQ_ACCRECORD",
            strategy = GenerationType.SEQUENCE
    )
    private long id;
    @Temporal(TemporalType.DATE)
    private Date recordDate;
    private String description;
    private String cashAmount;
    @OneToOne(
            cascade = {CascadeType.ALL}
    )
    private AccountingGroup accountingGroup;

    public AccountingRecord() {
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Date getRecordDate() {
        return this.recordDate;
    }

    public void setRecordDate(Date recordDate) {
        this.recordDate = recordDate;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCashAmount() {
        return this.cashAmount;
    }

    public void setCashAmount(String cashAmount) {
        this.cashAmount = cashAmount;
    }

    public AccountingGroup getAccountingGroup() {
        return this.accountingGroup;
    }

    public void setAccountingGroup(AccountingGroup accountingGroup) {
        this.accountingGroup = accountingGroup;
    }
}
