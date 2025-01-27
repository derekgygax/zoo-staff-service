package local.zoo.staffservice.dto.department;

import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record DepartmentIdentifier(
        @Schema(required = true, title = "ID", description = "Unique identifier of the Department") UUID id,
        @Schema(required = true, title = "Name", description = "Name of the department. Cannot be longer than 100 characters", maxLength = 100) String name) {
}
