package local.zoo.staffservice.dto.staff;

import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record StaffIdentifier(
        @Schema(required = true, title = "ID", description = "Unique identifier of the staff member") UUID id,
        @Schema(required = true, title = "First Name", maxLength = 100, description = "Staff first name") String firstName,
        @Schema(required = true, title = "Last Name", maxLength = 100, description = "Staff last name") String lastName) {
}
