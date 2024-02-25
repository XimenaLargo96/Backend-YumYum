package generation.com.BackendYumYum.Model;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "categories")
public class Category {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idcategories;

    @Column
    private String name;

    @Column
    private String description;

    @Column
    private String url_img;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "category" , orphanRemoval = true)
    @JsonManagedReference
    private List<Product> products;
}
