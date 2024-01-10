package dev.isa.tumit.sbggjapi.budget;

import dev.isa.tumit.sbggjapi.calendar.CalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class RequirementService {

    @Autowired
    private CalendarService calendarService;

    @Autowired
    private RequirementRepository requirementRepository;

    Requirement approve(LocalDate approveDate, Requirement requirement) {

        if (!calendarService.isWorkingDay(approveDate)) {
            throw new RuntimeException("not working day");
        }

        requirement.setStatus(Requirement.Status.APPROVED);

        return requirementRepository.save(requirement);
    }

}
