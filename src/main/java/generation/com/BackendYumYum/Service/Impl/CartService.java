package generation.com.BackendYumYum.Service.Impl;

import generation.com.BackendYumYum.DTO.CartDTO;
import generation.com.BackendYumYum.Model.Cart;
import generation.com.BackendYumYum.Repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartService implements generation.com.BackendYumYum.Service.CartService {

    private final CartRepository cartRepository;

    private final ConversionService conversionService;

    @Override
    public Cart createCart (Cart cart){
        return cartRepository.save(cart);
    }

    @Override
    public List<CartDTO> listCarts (){
        List<Cart> carts = cartRepository.findAll();
        List<CartDTO> cartsDTO = new ArrayList<>();
        if (carts.size() > 0){
            for (Cart cart : carts) {
                CartDTO cartDTO = conversionService.convert(cart , CartDTO.class);
                cartsDTO.add(cartDTO);
            }
            return cartsDTO;
        }
        else {
            throw new RuntimeException("No hay carts registrados");
        }

    }

    @Override
    public Optional<Cart> findCartById (Long id){
        return cartRepository.findById(id);
    }
}
