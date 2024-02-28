package generation.com.BackendYumYum.Service;

import generation.com.BackendYumYum.DTO.UserDTO;
import generation.com.BackendYumYum.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public UserDTO createUser (User user);
    public List<UserDTO> listUsers();
    public Optional<UserDTO> findUserById (Long id);
}
