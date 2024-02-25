package generation.com.BackendYumYum.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idcart;

    @Column
    private double total_price;

    @Column
    private int amount;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "products_idproducts" , nullable = false)
    private Product product;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "users_idusers" )
    private User user;

}
