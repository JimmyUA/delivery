package clients.service;

import clients.persistance.Client;
import clients.persistance.ClientsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClientsService {
    
    @Autowired
    private ClientsRepository clientsRepository;
    public Client add(Client client) {
        return clientsRepository.save(client);
    }

    public Optional<Client> findById(Long id) {
        return clientsRepository.findById(id);
    }

    public List findAll() {
        return clientsRepository.findAll();
    }
}
