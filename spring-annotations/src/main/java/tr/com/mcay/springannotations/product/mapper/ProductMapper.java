package tr.com.mcay.springannotations.product.mapper;

import org.mapstruct.Mapper;
import tr.com.mcay.springannotations.product.dto.ProductDTO;
import tr.com.mcay.springannotations.product.model.Product;

@Mapper(componentModel = "spring")
public interface ProductMapper {
    ProductDTO productToProductDTO(Product product);

    Product productDTOToProduct(ProductDTO productDTO);
}
