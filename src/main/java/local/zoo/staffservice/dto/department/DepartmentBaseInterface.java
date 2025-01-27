package local.zoo.staffservice.dto.department;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public sealed interface DepartmentBaseInterface permits DepartmentBase {
    @Schema(required = true, title = "Name", maxLength = 100, description = "Name of the Department. Cannot be longer than 100 characters.")
    String name();

    @Schema(required = true, title = "Description", maxLength = 500, description = "Description of the Department. Cannot be longer than 500 characters.")
    String description();
}
