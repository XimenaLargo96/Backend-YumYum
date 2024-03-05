package generation.com.BackendYumYum.Repository;

import generation.com.BackendYumYum.Model.Category;
import generation.com.BackendYumYum.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category , Long> {
    @Query("SELECT c.products FROM Category c WHERE c.idcategories = :categoryId")
    List<Product> findProductsByCategoryId(@Param("categoryId") Long categoryId);
}
