package generation.com.BackendYumYum.Service;

import generation.com.BackendYumYum.DTO.CartDTO;
import generation.com.BackendYumYum.DTO.ProductDTO;
import generation.com.BackendYumYum.Model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService{
    public CartDTO createCart (Cart cart);
    public List<CartDTO> listCarts ();
    public Optional<CartDTO> findCartById (Long id);
    public List<CartDTO> listProductsByUserId(Long userId);

}
