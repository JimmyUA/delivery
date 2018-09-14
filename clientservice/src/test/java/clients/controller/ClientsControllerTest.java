package clients.controller;

import clients.ClientsApplication;
import clients.PersistenceConfig;
import clients.TestContext;
import clients.persistance.Client;
import clients.service.ClientsService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class, ClientsApplication.class, PersistenceConfig.class})
@WebAppConfiguration
public class ClientsControllerTest {

    private MockMvc mockMvc;

    @Autowired
    private ClientsService clientsServiceMock;


    @Test
    public void longNameForTest() throws Exception {
        Client client = new Client();
        Client addedClient = new Client();
        String clientsName = "Gore";

        client.setName(clientsName);
        addedClient.setName(clientsName);
        addedClient.setId(1L);


        when(clientsServiceMock.add(any(Client.class))).thenReturn(addedClient);
    }
}