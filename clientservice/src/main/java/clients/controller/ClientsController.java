package clients.controller;

import clients.apis.DeliveriesClient;
import clients.persistance.Client;
import clients.persistance.ClientsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ClientsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientsController.class);

    @Autowired
    private ClientsRepository repository;

    @Autowired
    private DeliveriesClient deliveriesClient;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @PostMapping("/add")
    public Client add(@RequestBody Client client) {
        LOGGER.info("Employee add: {}", client);
        return repository.save(client);
    }

    @GetMapping("/{id}")
    public Optional<Client> findById(@PathVariable("id") Long id) {
        LOGGER.info("Employee find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping("/all")
    public List findAll() {
        LOGGER.info("Employee find");
        return repository.findAll();
    }

    @GetMapping("client/{id}/withDeliveries")
    public Client findByIdWithDeliveries(@PathVariable("id") Long id) {
        LOGGER.info("Employee find with deliveries: id={}", id);
        Optional<Client> client = repository.findById(id);
        if (!client.isPresent()){
            throw new RuntimeException("Client is not found");
        }
        Client clientInstance = client.get();
        clientInstance.setDeliveries(deliveriesClient.findDeliveriesByClient(id));
        return clientInstance;
    }


}
