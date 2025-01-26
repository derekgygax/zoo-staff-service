package local.zoo.staffservice.dto.staff;

import java.time.LocalDate;

import local.zoo.staffservice.enums.Title;

public record StaffBase(
        String firstName,
        String lastName,
        Title title,
        String email,
        String phoneNumber,
        LocalDate hireDate,
        LocalDate startDate) implements StaffBassInterface {
}
