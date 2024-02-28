package generation.com.BackendYumYum.Controller;

import generation.com.BackendYumYum.DTO.UserDTO;
import generation.com.BackendYumYum.Model.User;
import generation.com.BackendYumYum.Service.UserService;
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
    public ResponseEntity<List<UserDTO>> getAllUsers (){
        return ResponseEntity.ok(userService.listUsers());
    }

    @PostMapping("/save")
    public ResponseEntity<UserDTO> saveUser (@RequestBody User user){
        return ResponseEntity.ok(userService.createUser(user));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Optional<UserDTO>> getUserById (@PathVariable Long id){
        return ResponseEntity.ok(userService.findUserById(id));
    }
}
