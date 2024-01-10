package dev.isa.tumit.sbggjapi.calendar;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class CalendarService {

    // move to DB in next sprint 🙇
    List<LocalDate> publicHolidays = List.of(
            LocalDate.of(2024, 1, 1),
            LocalDate.of(2024, 12, 31)
    );

    public boolean isWorkingDay(LocalDate localDate) {
        return publicHolidays.contains(localDate);
    }

}
