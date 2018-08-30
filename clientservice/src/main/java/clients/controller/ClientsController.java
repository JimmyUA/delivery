package clients.controller;

import clients.persistance.Client;
import clients.persistance.ClientsRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class ClientsController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ClientsController.class);

    @Autowired
    ClientsRepository repository;

    @PostMapping
    public Client add(@RequestBody Client client) {
        LOGGER.info("Employee add: {}", client);
        return repository.save(client);
    }

    @GetMapping("/{id}")
    public Optional<Client> findById(@PathVariable("id") Long id) {
        LOGGER.info("Employee find: id={}", id);
        return repository.findById(id);
    }

    @GetMapping
    public List findAll() {
        LOGGER.info("Employee find");
        return repository.findAll();
    }


}
