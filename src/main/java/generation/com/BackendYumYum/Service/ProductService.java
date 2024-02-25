package generation.com.BackendYumYum.Service;

import generation.com.BackendYumYum.Model.Product;
import generation.com.BackendYumYum.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService {

    private final ProductRepository productRepository;


    public Product createProduct (Product product){
        return productRepository.save(product);
    }

    public List<Product> listProducts (){
        return productRepository.findAll();
    }

    public Optional<Product> findProductById (Long id){
        return productRepository.findById(id);
    }
}
