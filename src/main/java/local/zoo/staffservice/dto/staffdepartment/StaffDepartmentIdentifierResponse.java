package local.zoo.staffservice.dto.staffdepartment;

import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record StaffDepartmentIdentifierResponse(
        @Schema(required = true, title = "ID", description = "Unique identifier of the Staff Department combination") UUID id,
        @Schema(required = true, title = "Label", description = "A human readable label identifiying the Staff Department combination") String label) {
}
