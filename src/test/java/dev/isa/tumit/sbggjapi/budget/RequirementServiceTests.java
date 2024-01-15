package dev.isa.tumit.sbggjapi.budget;

import dev.isa.tumit.sbggjapi.utils.ModelUtils;
import dev.isa.tumit.sbggjapi.calendar.CalendarService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.time.LocalDate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class RequirementServiceTests {

    @InjectMocks
    private RequirementService requirementService;

    @Mock
    private CalendarService calendarService;

    @Mock
    private RequirementRepository requirementRepository;

    @Test
    void approve_StatusApproved_IsWorkingDay() {
        // * arrange
        LocalDate approveDate = LocalDate.of(2024, 1, 2);
        Requirement requirement = Requirement.builder()
                .id(1L)
                .title("Pen 1 unit")
                .contactMobileNo("0881234567")
                .status(Requirement.Status.PENDING)
                .build();

        Requirement savedRequirement = ModelUtils.copy(requirement, Requirement.class);
        savedRequirement.setStatus(Requirement.Status.APPROVED);

        when(calendarService.isWorkingDay(approveDate)).thenReturn(true);
        when(requirementRepository.save(requirement)).thenReturn(savedRequirement);

        // * act
        Requirement approvedRequirement = requirementService.approve(approveDate, requirement);

        // * assert
        assertThat(approvedRequirement).isEqualTo(savedRequirement);
    }

    @Test
    void approve_Exception_NotWorkingDay() {
        // * arrange
        LocalDate approveDate = LocalDate.of(2024, 1, 2);
        Requirement requirement = Requirement.builder()
                .id(1L)
                .title("Pen 1 unit")
                .contactMobileNo("0881234567")
                .status(Requirement.Status.PENDING)
                .build();

        Requirement savedRequirement = ModelUtils.copy(requirement, Requirement.class);
        savedRequirement.setStatus(Requirement.Status.APPROVED);

        when(calendarService.isWorkingDay(approveDate)).thenReturn(true);
        when(requirementRepository.save(requirement)).thenReturn(savedRequirement);

        // * act
        Requirement approvedRequirement = requirementService.approve(approveDate, requirement);

        // * assert
        assertThat(approvedRequirement).isEqualTo(savedRequirement);
    }

}
