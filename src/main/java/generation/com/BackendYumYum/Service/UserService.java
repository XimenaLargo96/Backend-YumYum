package generation.com.BackendYumYum.Service;

import generation.com.BackendYumYum.Model.User;
import generation.com.BackendYumYum.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public User createUser (User user){
        return userRepository.save(user);
    }

    public List<User> listUsers(){
        return userRepository.findAll();
    }

    public Optional<User> findUserById (Long id){
        return userRepository.findById(id);
    }

}
