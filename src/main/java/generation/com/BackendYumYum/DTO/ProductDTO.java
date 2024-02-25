package generation.com.BackendYumYum.DTO;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ProductDTO {

        private Long id;
        private String name;
        private double price;
        private String url_img;
}
