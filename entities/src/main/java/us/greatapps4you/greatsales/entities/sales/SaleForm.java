package us.greatapps4you.greatsales.entities.sales;

import java.io.Serializable;

public class SaleForm implements Serializable {

    private long id;
    private String description;
    private String htmlTemplate;

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
