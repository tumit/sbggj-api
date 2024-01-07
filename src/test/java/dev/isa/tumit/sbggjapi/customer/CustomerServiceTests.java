package dev.isa.tumit.sbggjapi.customer;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class CustomerServiceTests {

    @InjectMocks
    private CustomerService customerService;

    @Mock
    private CustomerRepository customerRepository;

    @Test
    void shouldWhen() {
        // * arrange
        when(customerRepository.findAll())
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

        List<Customer> actual = customerService.list();

        // * assert
        assertThat(actual.size()).isEqualTo(2);
    }
}
