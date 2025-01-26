package local.zoo.staffservice.resource;

import java.util.List;
import java.util.UUID;

import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import local.zoo.staffservice.dto.staff.StaffBase;
import local.zoo.staffservice.dto.staff.StaffIdentifier;
import local.zoo.staffservice.model.Staff;
import local.zoo.staffservice.service.StaffService;

@Path("/api/v1/staff")
public class StaffResource {

    @Inject
    StaffService staffService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Staff> getAllStaff() {
        return staffService.getAllStaff();
    }

    @GET
    @Path("/identifiers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StaffIdentifier> getAllStaffIdentifiers() {
        return this.staffService.getAllStaffIdentifiers();
    }

    @GET
    @Path("/{staffId}/base")
    @Produces(MediaType.APPLICATION_JSON)
    public StaffBase getStaffBaseById(@PathParam("staffId") UUID staffId) {
        return this.staffService.getStaffBaseById(staffId);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addStaff(StaffBase staffBase) {
        this.staffService.addStaff(staffBase);
    }

    @PUT
    @Path("/{staffId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateEnclosure(@PathParam("staffId") UUID staffId, StaffBase staffBase) {
        this.staffService.updateStaff(staffId, staffBase);
    }

}
