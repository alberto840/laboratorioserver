package bo.edu.ucb.msclientusuario.ApiUser;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import bo.edu.ucb.msclientusuario.services.PagoService;
import bo.edu.ucb.msclientusuario.services.PaymentDAO;

@CrossOrigin
@RestController
@RequestMapping(path = "api/v1/user")
public class UserController {
    private final UserService userService;

    @Autowired
    private PagoService pagoService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserEntity> getUsuar(){
        return userService.getUser();
    }

    @GetMapping("/userPayment")
    public ResponseEntity<List<PaymentDAO>> getPaymentByUserId(@RequestParam("userId") Long userId){
        ResponseEntity<List<PaymentDAO>> response = this.pagoService.getPaymentsByUserId(userId);
        return response;
    }

    @GetMapping("/testconn")
    public String test(){
        return "hola:"+this.pagoService.getData();
    }

    @PostMapping
    public ResponseEntity<Object> registerNewUsuar(@RequestBody UserEntity user){
        return this.userService.addNewUser(user);
    }
}
