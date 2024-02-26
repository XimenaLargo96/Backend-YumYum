package generation.com.BackendYumYum.Converter;

import generation.com.BackendYumYum.DTO.UserDTO;
import generation.com.BackendYumYum.Model.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@Builder
@AllArgsConstructor
public class UserToUserDTOConverter implements Converter<User , UserDTO> {

    @Override
    public UserDTO convert(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setIdusers(user.getIdusers());
        userDTO.setName(user.getName());
        userDTO.setEmail(user.getEmail());
        userDTO.setPhone(user.getPhone());
        return userDTO;
    }
}
