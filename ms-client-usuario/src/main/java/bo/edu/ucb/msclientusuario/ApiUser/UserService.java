package bo.edu.ucb.msclientusuario.ApiUser;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserEntity>getUser(){
        return this.userRepository.findAll();
    }
    public ResponseEntity<Object> addNewUser(UserEntity user) {  
        HashMap<String, Object> datos = new HashMap<>();

        userRepository.save(user);
        datos.put("datos", user);
        datos.put("message", "Se creo el usuario correctamente");
        return new ResponseEntity<>(datos, HttpStatus.CREATED);
    } 
}
