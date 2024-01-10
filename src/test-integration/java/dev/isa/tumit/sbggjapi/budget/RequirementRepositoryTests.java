package dev.isa.tumit.sbggjapi.budget;

import dev.isa.tumit.sbggjapi.AbstractContainerTest;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import static org.assertj.core.api.Assertions.assertThat;

@Slf4j
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
@Transactional(propagation = Propagation.NOT_SUPPORTED)
public class RequirementRepositoryTests extends AbstractContainerTest {

    @Autowired
    private RequirementRepository requirementRepository;

    @Test
    void save() {
        // * arrange
        Requirement requirement = Requirement.builder()
                .id(1L)
                .title("Pen 1 unit")
                .contactMobileNo("0881234567")
                .status(Requirement.Status.PENDING)
                .build();

        requirement.setStatus(Requirement.Status.APPROVED);

        // * act
        Requirement actual = requirementRepository.save(requirement);
        log.info("actual={}", actual);

        // * assert
        assertThat(actual.getStatus()).isEqualTo(Requirement.Status.APPROVED);
    }

}
