package deliveries.apis;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@FeignClient(name = "clients-service")
public interface ClientsClient {

    @GetMapping("/{id}")
    @ResponseBody
    List findDeliveriesByClient(@PathVariable("id") Long id);
}
