package clients.apis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(name = "deliveries-service")
public interface DeliveriesClient {

    @GetMapping("/client/{clientId}")
    List findDeliveriesByClient(@PathVariable("clientId") Long clientId);
}
