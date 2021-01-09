package br.com.greatsoft.greaterp.model.entity.sales;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(
        name = "SEQ_ENVIADO",
        sequenceName = "SEQ_ENVIADO",
        allocationSize = 0,
        initialValue = 1
)
public class Enviado implements Serializable {
    @Id
    @GeneratedValue(
            generator = "SEQ_ENVIADO",
            strategy = GenerationType.SEQUENCE
    )
    private long id;
    private String email;

    public Enviado() {
    }

    public String toString() {
        return this.email;
    }

    public long getId() {
        return this.id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
