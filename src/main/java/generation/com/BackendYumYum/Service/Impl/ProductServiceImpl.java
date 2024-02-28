package generation.com.BackendYumYum.Service.Impl;

import generation.com.BackendYumYum.DTO.ProductDTO;
import generation.com.BackendYumYum.Model.Product;
import generation.com.BackendYumYum.Repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements generation.com.BackendYumYum.Service.ProductService {

    private final ProductRepository productRepository;

    private final ConversionService conversionService;

    @Override
    public ProductDTO createProduct (Product product){
        productRepository.save(product);
        return conversionService.convert(product , ProductDTO.class);
    }

    @Override
    public List<ProductDTO> listProducts (){
        List<Product> products = productRepository.findAll();
        List<ProductDTO> productsDTO = new ArrayList<>();
        if (products.size() > 0){
            for (Product product : products) {
                ProductDTO productDTO = conversionService.convert(product , ProductDTO.class);
                productsDTO.add(productDTO);
            }
            return productsDTO;
        }
        else {
            throw new RuntimeException("No hay productos registrados");
        }
    }

    @Override
    public Optional<ProductDTO> findProductById (Long id){
        Optional<Product> searchedProduct =  productRepository.findById(id);
        if (searchedProduct.isPresent()){
            return searchedProduct.map(product -> conversionService.convert(product , ProductDTO.class));
        }
        else {
            throw new RuntimeException("El producto no existe");
        }
    }
}
