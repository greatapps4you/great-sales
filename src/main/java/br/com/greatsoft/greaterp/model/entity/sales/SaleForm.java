package br.com.greatsoft.greaterp.model.entity.sales;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(
        name = "SEQ_FORMPEDIDO",
        sequenceName = "SEQ_FORMPEDIDO",
        allocationSize = 0,
        initialValue = 1
)
public class SaleForm implements Serializable {
    @Id
    @GeneratedValue(
            generator = "SEQ_FORMPEDIDO",
            strategy = GenerationType.SEQUENCE
    )
    private long id;
    private String description;
    @Lob
    private String htmlTemplate;

    public SaleForm() {
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

    public String getHtmlTemplate() {
        return this.htmlTemplate;
    }

    public void setHtmlTemplate(String htmlTemplate) {
        this.htmlTemplate = htmlTemplate;
    }
}
