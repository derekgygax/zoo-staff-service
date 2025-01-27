package local.zoo.staffservice.dto.staffdepartment;

import java.util.UUID;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record StaffDepartmentBase(
        @Schema(required = true, title = "Staff", format = "selector", description = "Unique identifier of the staff member being assigned to the department") UUID staffId,
        @Schema(required = true, title = "Department", format = "selector", description = "Unique identifier of the department staff members are being assigned to") UUID departmentId,
        @Schema(required = true, title = "Role", description = "Role of the staff member in the department") String role) {

}
