package generation.com.BackendYumYum.Controller;

import generation.com.BackendYumYum.Model.User;
import generation.com.BackendYumYum.Service.Impl.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> getAllUsers (){
        return ResponseEntity.ok(userService.listUsers());
    }

    @PostMapping("/save")
    public ResponseEntity<User> saveUser (@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<User>> getUserById (@PathVariable Long id){
        return ResponseEntity.ok(userService.findUserById(id));
    }
}
