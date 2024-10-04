package tr.com.mcay.dependencyinjection.message;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

@SpringBootTest
@AutoConfigureMockMvc
public class MessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMessageController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/message"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Spring Framework"));
    }

    @Test
    public void testMessageControllerFieldBased() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/message-field-based"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Spring Framework"));
    }

    @Test
    public void testMessageControllerSetterBased() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/message-setter-based"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Spring Framework"));
    }
}
