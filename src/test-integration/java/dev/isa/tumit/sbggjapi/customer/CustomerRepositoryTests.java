package dev.isa.tumit.sbggjapi.customer;

import dev.isa.tumit.sbggjapi.AbstractContainerTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.DynamicPropertyRegistry;
import org.springframework.test.context.DynamicPropertySource;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.testcontainers.containers.MSSQLServerContainer;
import org.testcontainers.junit.jupiter.Container;
import org.testcontainers.junit.jupiter.Testcontainers;

import java.util.List;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
public class CustomerRepositoryTests extends AbstractContainerTest {

    @Autowired
    private CustomerRepository customerRepository;

    @Test
    void shouldWhen() {
        // * arrange
        // * act
        List<Customer> actual = customerRepository.findAll();

        // * assert
        log.info("actual={}", actual);
        assertThat(actual).hasSize(2);
    }

    @Test
    void shouldUpdateFirstName() {
        // * arrange
        // * act
        Customer c = customerRepository.findById(1L).orElseThrow();
        c.setFirstName("Cherprang");
        customerRepository.save(c);
        // * assert
        assertThat(c.getFirstName()).isEqualTo("Cherprang");
    }
}
