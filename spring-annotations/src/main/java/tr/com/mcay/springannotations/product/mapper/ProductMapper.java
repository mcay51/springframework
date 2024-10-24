package tr.com.mcay.springannotations.product.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import tr.com.mcay.springannotations.order.mapper.OrderMapper;
import tr.com.mcay.springannotations.product.dto.ProductDTO;
import tr.com.mcay.springannotations.product.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);
    ProductDTO productToProductDTO(Product product);

    Product productDTOToProduct(ProductDTO productDTO);
}
