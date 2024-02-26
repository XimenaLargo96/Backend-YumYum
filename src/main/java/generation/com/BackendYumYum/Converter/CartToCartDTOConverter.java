package generation.com.BackendYumYum.Converter;

import generation.com.BackendYumYum.DTO.CartDTO;
import generation.com.BackendYumYum.DTO.ProductDTO;
import generation.com.BackendYumYum.DTO.UserDTO;
import generation.com.BackendYumYum.Model.Cart;
import generation.com.BackendYumYum.Model.Product;
import generation.com.BackendYumYum.Model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@Builder
@AllArgsConstructor
public class CartToCartDTOConverter implements Converter<Cart , CartDTO> {

    private final Converter<Product , ProductDTO> productConverter;
    private final Converter<User , UserDTO> userConverter;

    @Override
    public CartDTO convert(Cart cart) {
        CartDTO cartDTO = new CartDTO();
        cartDTO.setIdcart(cart.getIdcart());
        cartDTO.setUser(userConverter.convert(cart.getUser()));
        cartDTO.setProduct(productConverter.convert(cart.getProduct()));
        cartDTO.setTotal_price(cart.getTotal_price());
        cartDTO.setAmount(cart.getAmount());
        return cartDTO;
    }
}
