package clients;

import clients.controller.ClientsController;
import clients.persistance.ClientsRepository;
import clients.service.ClientsService;
import org.mockito.Mockito;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestContext {

    @Bean
    public ClientsService clientsServiceMock(){
        return Mockito.mock(ClientsService.class);
    }

    @Bean
    public ClientsController clientsController(){
        return  new ClientsController();
    }

    @Bean
    public ClientsRepository clientsRepository(){
        return Mockito.mock(ClientsRepository.class);
    }
}
