package local.zoo.staffservice.dto;

import org.eclipse.microprofile.openapi.annotations.media.Schema;

public record ModelIdentifier(
        @Schema(required = true, title = "ID", description = "Unique identifier of that instance of the Model as a string") String id,
        @Schema(required = true, title = "Label", description = "A human readable label to identify that instance of the Model") String label) {
}
