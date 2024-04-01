package app.loja.controller;

import app.loja.entity.Venda;
import app.loja.repository.VendaRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;


@SpringBootTest
@AutoConfigureMockMvc
public class VendaControllerTest {

    @Autowired
    MockMvc mockMvc;

    @MockBean
    VendaController vendaController;

    @Autowired
    ObjectMapper objectMapper;

    @MockBean
    VendaRepository vendaRepository;


    @Test
    @DisplayName("Teste de integração para a requisição HTTP POST")
    void MetodoPost() throws Exception {
        Venda venda = new Venda();
        Mockito.when(vendaRepository.save(Mockito.any())).thenReturn(venda);

        this.mockMvc.perform(post("/api/venda/save")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content("{\"id\":1,\"endereco\":\"Rua Street\",\"total\": 250.0,\"formaPagamento\":\"Pix\",\"status\":\"Cancelado\"}")
                        .accept(MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(content().json("{'id': 1, 'endereco': 'Rua Street', 'total': 250.0, 'formaPagamento': 'Pix', 'status': 'Cancelado'}"));
    }

}
