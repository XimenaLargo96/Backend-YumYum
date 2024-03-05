package generation.com.BackendYumYum.Service;

import generation.com.BackendYumYum.DTO.CategoryDTO;
import generation.com.BackendYumYum.DTO.ProductDTO;
import generation.com.BackendYumYum.Model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public CategoryDTO createCategory (Category category);
    public List<CategoryDTO> listCategories ();
    public Optional<CategoryDTO> findCategoryById (Long id);
    public List<ProductDTO> findProductsByCategory(Long categoryId);

}
