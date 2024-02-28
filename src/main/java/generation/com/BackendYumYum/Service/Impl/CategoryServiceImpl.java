package generation.com.BackendYumYum.Service.Impl;

import generation.com.BackendYumYum.DTO.CategoryDTO;
import generation.com.BackendYumYum.Model.Category;
import generation.com.BackendYumYum.Repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CategoryServiceImpl implements generation.com.BackendYumYum.Service.CategoryService {

    private final CategoryRepository categoryRepository;

    private final ConversionService conversionService;

    @Override
    public CategoryDTO createCategory (Category category){
        categoryRepository.save(category);
        return conversionService.convert(category , CategoryDTO.class);
    }

    @Override
    public List<CategoryDTO> listCategories () {
        List<Category> categories = categoryRepository.findAll();
        List<CategoryDTO> categoriesDTO = new ArrayList<>();
        if (categories.size() > 0){
            for (Category category : categories) {
                CategoryDTO categoryDTO = conversionService.convert(category , CategoryDTO.class);
                categoriesDTO.add(categoryDTO);
            }
            return categoriesDTO;
        }
        throw new RuntimeException("No hay categorias registradas");
    }

    @Override
    public Optional<CategoryDTO> findCategoryById (Long id) {
        Optional<Category> searchedCategory = categoryRepository.findById(id);
        if (searchedCategory.isPresent()){
            return searchedCategory.map(category -> conversionService.convert(category , CategoryDTO.class));
        }
        throw new RuntimeException("No existe esa categoria");
    }

}
