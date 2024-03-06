package generation.com.BackendYumYum.Controller;

import generation.com.BackendYumYum.DTO.ProductDTO;
import generation.com.BackendYumYum.Model.Product;
import generation.com.BackendYumYum.Service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/products")
@RequiredArgsConstructor
public class ProductController {


    private final ProductService productService;

    @PostMapping("/save")
    public ResponseEntity<ProductDTO> saveProduct(@RequestBody Product product){
        return ResponseEntity.ok( productService.createProduct(product));
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts(){
        return ResponseEntity.ok(productService.listProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<ProductDTO>> getProductById(@PathVariable Long id) {
        return ResponseEntity.ok(productService.findProductById(id));
    }

    @GetMapping("/price")
    public ResponseEntity<List<ProductDTO>> getProductsByPrice(){
        return ResponseEntity.ok(productService.listProductsByPrice());
    }
    @GetMapping("/price/desc")
    public ResponseEntity<List<ProductDTO>> getProductsByPriceDesc(){
        return ResponseEntity.ok(productService.listProductsByPriceDesc());
    }

}
