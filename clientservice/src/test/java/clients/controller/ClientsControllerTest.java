package clients.controller;

import clients.TestContext;
import clients.persistance.Client;
import clients.service.ClientsService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import javax.ws.rs.core.MediaType;

import static org.mockito.Mockito.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;


@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = {TestContext.class})
@SpringBootTest
@WebAppConfiguration
@AutoConfigureMockMvc
public class ClientsControllerTest {

    @Autowired
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


        ObjectMapper mapper = new ObjectMapper();
        String clientJson = mapper.writeValueAsString(client);

        mockMvc.perform(post("/add")
                .contentType(MediaType.APPLICATION_JSON)
                .content(clientJson))
                .andExpect(status().isOk());
    }
}