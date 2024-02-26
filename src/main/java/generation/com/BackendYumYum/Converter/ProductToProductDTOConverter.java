package generation.com.BackendYumYum.Converter;


import generation.com.BackendYumYum.DTO.ProductDTO;
import generation.com.BackendYumYum.Model.Product;
import lombok.Builder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@Builder
public class ProductToProductDTOConverter implements Converter<Product , ProductDTO> {
    @Override
    public ProductDTO convert(Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setIdproducts(product.getIdproducts());
        productDTO.setName(product.getName());
        productDTO.setPrice(product.getPrice());
        productDTO.setUrl_img(product.getUrl_img());
        return productDTO;
    }
}
