package generation.com.BackendYumYum.Service;

import generation.com.BackendYumYum.Model.Cart;
import generation.com.BackendYumYum.Repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService {

    private final CartRepository cartRepository;

    public Cart createCart (Cart cart){
        return cartRepository.save(cart);
    }

    public List<Cart> listCarts (){
        return cartRepository.findAll();
    }

    public Optional<Cart> findCartById (Long id){
        return cartRepository.findById(id);
    }
}
