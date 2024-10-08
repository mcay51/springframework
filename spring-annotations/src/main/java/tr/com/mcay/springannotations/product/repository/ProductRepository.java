package tr.com.mcay.springannotations.product.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.mcay.springannotations.product.model.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {
}
