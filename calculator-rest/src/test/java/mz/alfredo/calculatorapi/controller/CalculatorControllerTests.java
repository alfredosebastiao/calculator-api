package mz.alfredo.calculatorapi.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@SpringBootTest
@AutoConfigureMockMvc
public class CalculatorControllerTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void shouldReturnSumOfNumbers() throws Exception {
        this.mockMvc.perform(get("/sum")
                .param("a","10")
                .param("b","10")
                .contentType("application/json"))
                .andExpect(status().isOk());

    }


    @Test
    public void shouldReturnSubtractionOfNumbers() throws Exception {
        this.mockMvc.perform(get("/subtract")
                .param("a","10")
                .param("b","10")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnMultiplicationOfNumbers() throws Exception {
        this.mockMvc.perform(get("/multiply")
                .param("a","10")
                .param("b","10")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnDivisionOfNumbers() throws Exception {
        this.mockMvc.perform(get("/divide")
                .param("a","10")
                .param("b","10")
                .contentType("application/json"))
                .andExpect(status().isOk());
    }

    @Test
    public void shouldReturnNotAcceptable() throws Exception {
        this.mockMvc.perform(get("/divide")
                .param("a","10")
                .param("b","0")
                .contentType("application/json"))
                .andExpect(status().isNotAcceptable());
    }


}
