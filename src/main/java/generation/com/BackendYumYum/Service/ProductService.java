package generation.com.BackendYumYum.Service;

import generation.com.BackendYumYum.Model.Product;

import java.util.List;
import java.util.Optional;

public interface ProductService {
    public Product createProduct (Product product);
    public List<Product> listProducts ();
    public Optional<Product> findProductById(Long id);

}
