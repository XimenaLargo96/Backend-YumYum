package generation.com.BackendYumYum.Service.Impl;

import generation.com.BackendYumYum.Model.User;
import generation.com.BackendYumYum.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService implements generation.com.BackendYumYum.Service.UserService {

    private final UserRepository userRepository;

    @Override
    public User createUser (User user){
        return userRepository.save(user);
    }

    @Override
    public List<User> listUsers(){
        return userRepository.findAll();
    }

    @Override
    public Optional<User> findUserById (Long id){
        return userRepository.findById(id);
    }

}
