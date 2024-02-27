package generation.com.BackendYumYum.Service.Impl;

import generation.com.BackendYumYum.Model.Product;
import generation.com.BackendYumYum.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductService implements generation.com.BackendYumYum.Service.ProductService {

    private final ProductRepository productRepository;

    @Override
    public Product createProduct (Product product){
        return productRepository.save(product);
    }

    @Override
    public List<Product> listProducts (){
        return productRepository.findAll();
    }

    @Override
    public Optional<Product> findProductById (Long id){
        return productRepository.findById(id);
    }
}
