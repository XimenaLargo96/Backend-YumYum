package generation.com.BackendYumYum.Service.Impl;

import generation.com.BackendYumYum.Model.Category;
import generation.com.BackendYumYum.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryService implements generation.com.BackendYumYum.Service.CategoryService {

    private final CategoryRepository categoryRepository;

    @Override
    public Category createCategory (Category category){
        return categoryRepository.save(category);
    }

    @Override
    public List<Category> listCategories () {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findCategoryById (Long id) {
        return categoryRepository.findById(id);
    }

}
