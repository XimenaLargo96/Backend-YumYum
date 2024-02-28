package generation.com.BackendYumYum.Model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "products")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idproducts;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private int amount_stock;

    @Column
    private double price;

    @Column
    private boolean has_color;

    @Column
    private String colors;

    @Column
    private String url_img;

    @ManyToOne
    @JoinColumn(name = "categories_idcategories" , nullable = false)
    @JsonBackReference
    Category category;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "product")
    private List<Cart> carts;
}
