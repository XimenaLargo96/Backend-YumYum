package generation.com.BackendYumYum.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class CartDTO {

    private Long idcart;
    private double total_price;
    private int amount;
    private ProductDTO product;
    private UserDTO user;
}
