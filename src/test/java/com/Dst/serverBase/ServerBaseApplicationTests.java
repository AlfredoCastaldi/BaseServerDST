package com.Dst.serverBase;

import com.Dst.serverBase.controller.HelloWorld;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.when;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@WebMvcTest(HelloWorld.class)
class ServerBaseApplicationTests {



    @Test
    void contextLoads() {

    }

    @Autowired
    private MockMvc mockMvc;
    @Mock
    HelloWorld myMock;

    @Test
    void isMockitoWorking() {
        when(myMock.toString()).thenReturn("AAA");
        assertEquals("AAA", myMock.toString());
        Class<RuntimeException> exceptionClass = RuntimeException.class;
        assertThrows(exceptionClass, () -> {
            Integer.parseInt("a");
        });
    }

    @Test
    void helloWorldIsGood() throws Exception {
        mockMvc.perform(get("/home)"))
                .andExpect(status().isOk())
                .andExpect(content().string("ciao"));


    }
}
