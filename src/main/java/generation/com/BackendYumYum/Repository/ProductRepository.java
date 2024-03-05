package generation.com.BackendYumYum.Repository;

import generation.com.BackendYumYum.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product , Long> {
    @Query("FROM Product p ORDER BY p.price")
    List<Product> findAllOrderByPrice();

    @Query("FROM Product p ORDER BY p.price DESC")
    List<Product> findAllOrderByPriceDesc();
}
