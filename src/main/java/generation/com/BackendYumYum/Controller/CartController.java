package generation.com.BackendYumYum.Controller;

import generation.com.BackendYumYum.DTO.CartDTO;
import generation.com.BackendYumYum.DTO.ProductDTO;
import generation.com.BackendYumYum.Model.Cart;
import generation.com.BackendYumYum.Service.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;


    @PostMapping
    public ResponseEntity<CartDTO> saveCart (@RequestBody Cart cart){
        return ResponseEntity.ok(cartService.createCart(cart));
    }

    @GetMapping
    public List<CartDTO> getAllCarts (){
        return cartService.listCarts();
    }

   @GetMapping("/products/{userId}")
    public List<CartDTO> getProductsByUserId (@PathVariable Long userId){
        return cartService.listProductsByUserId(userId);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<CartDTO>> getCartById(@PathVariable Long id){
        return ResponseEntity.ok(cartService.findCartById(id));
    }
}
