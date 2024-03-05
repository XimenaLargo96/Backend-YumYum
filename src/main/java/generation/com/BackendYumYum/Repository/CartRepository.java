package generation.com.BackendYumYum.Repository;

import generation.com.BackendYumYum.DTO.ProductDTO;
import generation.com.BackendYumYum.Model.Cart;
import generation.com.BackendYumYum.Model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart , Long> {

    @Query("SELECT c FROM Cart c WHERE c.user.idusers = :userId")
    List<Cart> findProductsByUserId(@Param("userId") Long userId);
}
