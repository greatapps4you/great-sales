package br.com.greatsoft.greaterp.model.entity.sales;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;

@Entity
public class Salesman implements Serializable {
    @Id
    private final long id = 1L;
    private String name;
    private String email;
    private String phone;
    private String cellPhone;
    @Lob
    private String password;

    public Salesman() {
    }

    public String toString() {
        return this.name + " - " + this.email + " - " + this.phone + " - " + this.cellPhone;
    }

    public long getId() {
        return this.id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return this.phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getCellPhone() {
        return this.cellPhone;
    }

    public void setCellPhone(String cellPhone) {
        this.cellPhone = cellPhone;
    }

    public String getPassword() {
        return this.password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
