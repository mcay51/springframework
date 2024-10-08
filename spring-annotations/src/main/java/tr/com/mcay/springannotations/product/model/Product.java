package tr.com.mcay.springannotations.product.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import tr.com.mcay.springannotations.model.BaseEntity;

@Entity
@Table("tbl_product")
public class Product extends BaseEntity {
    private String name;
    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
