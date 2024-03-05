package generation.com.BackendYumYum.Controller;

import generation.com.BackendYumYum.DTO.CategoryDTO;
import generation.com.BackendYumYum.DTO.ProductDTO;
import generation.com.BackendYumYum.Model.Category;
import generation.com.BackendYumYum.Service.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
@CrossOrigin(origins = "http://127.0.0.1:5501")
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<CategoryDTO> saveCategory (@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @GetMapping
    public ResponseEntity<List<CategoryDTO>> getAllCategories () {
        return ResponseEntity.ok(categoryService.listCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CategoryDTO>> getCategoryById (@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findCategoryById(id));
    }

    @GetMapping("/products/{idCategory}")
    public ResponseEntity<List<ProductDTO>> getProductsByCategory(@PathVariable Long idCategory){
        return ResponseEntity.ok(categoryService.findProductsByCategory(idCategory));
    }

}
