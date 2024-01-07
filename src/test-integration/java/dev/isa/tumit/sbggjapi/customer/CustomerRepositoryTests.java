package dev.isa.tumit.sbggjapi.customer;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
@AutoConfigureTestDatabase(replace= AutoConfigureTestDatabase.Replace.NONE)
public class CustomerRepositoryTests {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void shouldWhen() {
        // * arrange
        // * act
        List<Customer> actual = customerRepository.findAll();

        // * assert
        assertThat(actual.size()).isEqualTo(2);
    }


}
