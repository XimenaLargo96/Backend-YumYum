package generation.com.BackendYumYum.Service;

import generation.com.BackendYumYum.DTO.ProductDTO;
import generation.com.BackendYumYum.Model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public ProductDTO createProduct (Product product);
    public List<ProductDTO> listProducts ();
    public Optional<ProductDTO> findProductById(Long id);

}
