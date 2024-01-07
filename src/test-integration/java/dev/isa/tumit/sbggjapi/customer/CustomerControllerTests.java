package dev.isa.tumit.sbggjapi.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.test.web.servlet.MockMvc;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

@WebMvcTest(CustomerController.class)
public class CustomerControllerTests {

    @Autowired
    private MockMvc mvc;

    @MockBean
    private CustomerService customerService;

    @Test
    void shouldWhen() throws Exception {
        // * arrange
        when(customerService.list())
                .thenReturn(List.of(
                        Customer.builder()
                                .id(1L)
                                .firstName("First")
                                .lastName("Test")
                                .build(),
                        Customer.builder()
                                .id(1L)
                                .firstName("Second")
                                .lastName("Test")
                                .build()));
        // * act
        var req = get("/customers");
        var res = mvc.perform(req)
                .andReturn()
                .getResponse();

        // * assert
        assertThat(res.getStatus()).isEqualTo(HttpStatus.OK.value());
    }
}
