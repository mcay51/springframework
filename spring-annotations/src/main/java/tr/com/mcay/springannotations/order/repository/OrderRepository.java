package tr.com.mcay.springannotations.order.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tr.com.mcay.springannotations.order.model.Order;
@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

}
