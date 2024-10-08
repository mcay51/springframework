package tr.com.mcay.springannotations.order.model;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import tr.com.mcay.springannotations.model.BaseEntity;
import tr.com.mcay.springannotations.product.model.Product;

import java.util.List;

@Entity
@Table(name="tbl_order")
public class Order extends BaseEntity {

    private String customerName;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Product> products;

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
