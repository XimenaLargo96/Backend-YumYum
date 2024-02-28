package generation.com.BackendYumYum.Service.Impl;

import generation.com.BackendYumYum.DTO.CartDTO;
import generation.com.BackendYumYum.DTO.ProductDTO;
import generation.com.BackendYumYum.Model.Cart;
import generation.com.BackendYumYum.Model.Product;
import generation.com.BackendYumYum.Repository.CartRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CartServiceImpl implements generation.com.BackendYumYum.Service.CartService {

    private final CartRepository cartRepository;

    private final ConversionService conversionService;

    @Override
    public CartDTO createCart (Cart cart){
        cartRepository.save(cart);
        return conversionService.convert(cart , CartDTO.class);
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
    public Optional<CartDTO> findCartById (Long id){
        Optional<Cart> searchedCart = cartRepository.findById(id);
        if (searchedCart.isPresent()){
            return searchedCart.map(cart -> conversionService.convert(cart , CartDTO.class));
        }
        else {
            throw new RuntimeException("El usuario no existe");
        }
    }

    @Override
    public List<ProductDTO> listProductsByUserId(Long userId) {
        List<Product> products = cartRepository.findProductsByUserId(userId);
        List<ProductDTO> productsDTO = new ArrayList<>();
        if (products.size() > 0){
            for (Product product : products) {
                ProductDTO productDTO = conversionService.convert(product , ProductDTO.class);
                productsDTO.add(productDTO);
            }
            return productsDTO;
        }else {
            throw new RuntimeException("El usuario no tiene productos en su carrito");
        }
    }


}
