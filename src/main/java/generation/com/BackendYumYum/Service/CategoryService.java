package generation.com.BackendYumYum.Service;

import generation.com.BackendYumYum.Model.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryService {
    public Category createCategory (Category category);
    public List<Category> listCategories ();
    public Optional<Category> findCategoryById (Long id);

}
