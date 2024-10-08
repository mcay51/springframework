package tr.com.mcay.springannotations.order.dto;

import tr.com.mcay.springannotations.product.dto.ProductDTO;

import java.time.LocalDateTime;
import java.util.List;

public class OrderDTO {
    private Long id;
    private String customerName;
    private List<ProductDTO> products;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}
