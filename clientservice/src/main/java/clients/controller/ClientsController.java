package clients.controller;

import clients.apis.DeliveriesClient;
import clients.persistance.Client;
import clients.persistance.ClientsRepository;
import clients.service.ClientsService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin
@RestController
public class ClientsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientsController.class);

    @Autowired
    private ClientsService clientsService;

    @Autowired
    private DeliveriesClient deliveriesClient;

    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    @PostMapping("/add")
    public ResponseEntity add(@RequestBody Client client) {
        LOGGER.info("Client add: {}", client);
        return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(clientsService.add(client));
    }

    @GetMapping("/{id}")
    public Optional<Client> findById(@PathVariable("id") Long id) {
        LOGGER.info("Client find: id={}", id);
        return clientsService.findById(id);
    }

    @GetMapping("/all")
    public List findAll() {
        LOGGER.info("Client find");
        return clientsService.findAll();
    }

    @GetMapping("client/{id}/withDeliveries")
    public Client findByIdWithDeliveries(@PathVariable("id") Long id) {
        LOGGER.info("Employee find with deliveries: id={}", id);
        Optional<Client> client = clientsService.findById(id);
        if (!client.isPresent()){
            throw new RuntimeException("Client is not found");
        }
        Client clientInstance = client.get();
        clientInstance.setDeliveries(deliveriesClient.findDeliveriesByClient(id));
        return clientInstance;
    }


}
