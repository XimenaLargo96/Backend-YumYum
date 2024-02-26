package generation.com.BackendYumYum.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(nullable = false)
    private Long idusers;

    @Column
    private String name;

    @Column
    private String phone;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String role;

    @OneToMany(cascade = CascadeType.ALL , mappedBy = "user")
    @JsonIgnore
    private List<Cart> carts;
}
