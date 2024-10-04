package tr.com.mcay.aspectorientedprogramming.message;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class AOPMessageControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testMessageController() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/api/aop/message"))
                .andExpect(status().isOk())
                .andExpect(content().string("Spring Framework Aspect Oriented Programming Message"));
    }
}

