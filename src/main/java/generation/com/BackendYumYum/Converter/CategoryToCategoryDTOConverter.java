package generation.com.BackendYumYum.Converter;

import generation.com.BackendYumYum.DTO.CategoryDTO;
import generation.com.BackendYumYum.Model.Category;
import lombok.Builder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@Builder
public class CategoryToCategoryDTOConverter implements Converter<Category , CategoryDTO> {
    @Override
    public CategoryDTO convert(Category category) {
        CategoryDTO categoryDTO = new CategoryDTO();
        categoryDTO.setIdcategories(category.getIdcategories());
        categoryDTO.setName(category.getName());
        categoryDTO.setDescription(category.getDescription());
        categoryDTO.setUrl_img(category.getUrl_img());
        return categoryDTO;
    }
}
