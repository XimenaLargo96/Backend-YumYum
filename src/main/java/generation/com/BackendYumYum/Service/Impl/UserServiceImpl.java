package generation.com.BackendYumYum.Service.Impl;

import generation.com.BackendYumYum.DTO.ProductDTO;
import generation.com.BackendYumYum.DTO.UserDTO;
import generation.com.BackendYumYum.Model.User;
import generation.com.BackendYumYum.Repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements generation.com.BackendYumYum.Service.UserService {

    private final UserRepository userRepository;

    private final ConversionService conversionService;

    @Override
    public UserDTO createUser (User user){
        userRepository.save(user);
        return conversionService.convert(user , UserDTO.class);
    }

    @Override
    public List<UserDTO> listUsers(){
        List<User> users = userRepository.findAll();
        List<UserDTO> usersDTO = new ArrayList<>();
        if (users.size() > 0){
            for (User user : users) {
                UserDTO userDTO = conversionService.convert(user , UserDTO.class);
                usersDTO.add(userDTO);
            }
            return usersDTO;
        }
       else {
           throw new RuntimeException("No hay usuarios registrados");
        }
    }

    @Override
    public Optional<UserDTO> findUserById (Long id){
        Optional<User> searchedUser = userRepository.findById(id);
        if (searchedUser.isPresent()){
            return searchedUser.map(user -> conversionService.convert(user , UserDTO.class ));
        }
        else {
            throw new RuntimeException("El usuario no existe");
        }
    }

}
