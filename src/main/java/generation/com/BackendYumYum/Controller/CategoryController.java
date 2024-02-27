package generation.com.BackendYumYum.Controller;

import generation.com.BackendYumYum.Model.Category;
import generation.com.BackendYumYum.Service.Impl.CategoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/categories")
@RequiredArgsConstructor
public class CategoryController {

    private final CategoryService categoryService;

    @PostMapping("/save")
    public ResponseEntity<Category> saveCategory (@RequestBody Category category) {
        return ResponseEntity.ok(categoryService.createCategory(category));
    }

    @GetMapping
    public ResponseEntity<List<Category>> getAllCategories () {
        return ResponseEntity.ok(categoryService.listCategories());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<Category>> getCategoryById (@PathVariable Long id) {
        return ResponseEntity.ok(categoryService.findCategoryById(id));
    }

}
