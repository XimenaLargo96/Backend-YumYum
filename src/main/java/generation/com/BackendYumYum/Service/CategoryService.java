package generation.com.BackendYumYum.Service;

import generation.com.BackendYumYum.Model.Category;
import generation.com.BackendYumYum.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public Category createCategory (Category category){
        return categoryRepository.save(category);
    }

    public List<Category> listCategories () {
        return categoryRepository.findAll();
    }

    public Optional<Category> findCategoryById (Long id) {
        return categoryRepository.findById(id);
    }

}
