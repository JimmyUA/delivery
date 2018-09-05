package deliveries.controller;

import deliveries.apis.ClientsClient;
import deliveries.persistance.Delivery;
import deliveries.persistance.DeliveryRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class DeliveriesController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DeliveriesController.class);

    @Autowired
    private ClientsClient clientsClient;

    @Autowired
    private DeliveryRepository repository;

    @PostMapping
    public Delivery add(@RequestBody Delivery delivery) {
        LOGGER.info("Delivery add: {}", delivery);
        return repository.save(delivery);
    }

    @GetMapping("/{id}")
    public Optional<Delivery> findById(@PathVariable("id") Long id) {
        LOGGER.info("Delivery find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/all")
    public List findAll() {
        LOGGER.info("Delivery find");
        return repository.findAll();
    }

    @GetMapping("client/{clientId}")
    public List findByClient(@PathVariable("clientId") Long clientId) {
        LOGGER.info("Deliveries find by client: clientId={}", clientId);
        return repository.findByClient(clientId);
    }

}
