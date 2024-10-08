package tr.com.mcay.springannotations.order.mapper;

import org.mapstruct.Mapper;
import tr.com.mcay.springannotations.order.dto.OrderDTO;
import tr.com.mcay.springannotations.order.model.Order;

@Mapper(componentModel = "spring")
public interface OrderMapper {

    OrderDTO orderToOrderDTO(Order order);

    Order orderDTOToOrder(OrderDTO orderDTO);
}

