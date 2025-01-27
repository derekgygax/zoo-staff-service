package local.zoo.staffservice.dto.staff;

import java.time.LocalDate;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import local.zoo.staffservice.enums.Title;

public sealed interface StaffBaseInterface permits StaffBase, StaffResponse {
    @Schema(required = true, title = "First Name", maxLength = 100, description = "Staff first name")
    String firstName();

    @Schema(required = true, title = "Last Name", maxLength = 100, description = "Staff last name")
    String lastName();

    @Schema(required = true, title = "Title", description = "The job title of the staff member, selected from the enum of Title")
    Title title();

    @Schema(required = true, title = "Email", maxLength = 255, format = "email", description = "Email of the staff member")
    @Email(message = "Invalid email format")
    String email();

    @Schema(required = true, title = "Phone Number", maxLength = 15, description = "Phone number of the staff member")
    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid phone number format")
    String phoneNumber();

    // implementation = LocalDate.class is required to make this a type string
    // format date in the openapi
    @Schema(implementation = LocalDate.class, required = true, title = "Hire Date", description = "The date the staff member was hired", format = "date")
    LocalDate hireDate();

    @Schema(implementation = LocalDate.class, required = true, title = "Start Date", description = "The date the staff member started working", format = "date")
    LocalDate startDate();

}
