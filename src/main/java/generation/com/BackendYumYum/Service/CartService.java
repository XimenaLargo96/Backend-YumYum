package generation.com.BackendYumYum.Service;

import generation.com.BackendYumYum.DTO.CartDTO;
import generation.com.BackendYumYum.Model.Cart;

import java.util.List;
import java.util.Optional;

public interface CartService{
    public Cart createCart (Cart cart);
    public List<CartDTO> listCarts ();
    public Optional<Cart> findCartById (Long id);

}
