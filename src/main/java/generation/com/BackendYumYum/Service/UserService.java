package generation.com.BackendYumYum.Service;

import generation.com.BackendYumYum.Model.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    public User createUser (User user);
    public List<User> listUsers();
    public Optional<User> findUserById (Long id);
}
