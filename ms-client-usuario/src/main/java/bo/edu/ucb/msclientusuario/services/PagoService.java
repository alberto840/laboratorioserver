package bo.edu.ucb.msclientusuario.services;
import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("ms-client-pago")
public interface PagoService {

    @GetMapping("/api/v1/payment/testconn")
    String getData();

    @GetMapping("/api/v1/payment/list")
    ResponseEntity<List<PaymentDAO>> getPaymentsByUserId(@RequestParam("userId")Long userId);
}
