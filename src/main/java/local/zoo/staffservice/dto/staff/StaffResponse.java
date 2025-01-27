package local.zoo.staffservice.dto.staff;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import local.zoo.staffservice.enums.Title;
import local.zoo.staffservice.model.StaffDepartment;

public record StaffResponse(
        String firstName,
        String lastName,
        Title title,
        String email,
        String phoneNumber,
        LocalDate hireDate,
        LocalDate startDate,
        @Schema(required = true, title = "ID", description = "Unique identifier of the staff member") UUID id,
        @Schema(required = true, title = "Time Record Created", description = "The time the record was created") Instant createdAt,
        @Schema(required = true, title = "Time Record Updated", description = "The time the record was last udpated") Instant updatedAt,
        @Schema(required = true, title = "Staff Departments", description = "List of Staff Departments") List<StaffDepartment> staffDepartments)
        implements StaffBaseInterface {
}
