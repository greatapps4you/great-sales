package us.greatapps4you.greatsales.entities.sales;

import java.io.Serializable;

public class Enviado implements Serializable {

    private long id;
    private String email;

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
