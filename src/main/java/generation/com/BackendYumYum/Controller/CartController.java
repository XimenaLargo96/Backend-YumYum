package generation.com.BackendYumYum.Controller;

import generation.com.BackendYumYum.DTO.CartDTO;
import generation.com.BackendYumYum.Model.Cart;
import generation.com.BackendYumYum.Service.Impl.CartService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/carts")
@RequiredArgsConstructor
public class CartController {

    private final CartService cartService;


    @PostMapping
    public ResponseEntity<Cart> saveCart (@RequestBody Cart cart){
        return ResponseEntity.ok(cartService.createCart(cart));
    }

    @GetMapping
    public List<CartDTO> getAllCarts (){
        return cartService.listCarts();
    }

}
