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
import local.zoo.staffservice.service.StaffDepartmentService;
import local.zoo.staffservice.dto.ModelIdentifier;
import local.zoo.staffservice.dto.staffdepartment.StaffDepartmentBase;
import local.zoo.staffservice.model.StaffDepartment;

@Path("/api/v1/staff-departments")
public class StaffDepartmentResource {

    @Inject
    StaffDepartmentService staffDepartmentService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StaffDepartment> getAllStaffDepartments() {
        return this.staffDepartmentService.getAllStaffDepartments();
    }

    @GET
    @Path("/identifiers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ModelIdentifier> getAllStaffDepartmentIdentifiers() {
        return this.staffDepartmentService.getAllStaffDepartmentIdentifiers();
    }

    // TODO should the base come back with the Staff and Department or just the ID?
    // it will affect the front end if you change the base ... but you gotta do it
    // right
    @GET
    @Path("/{staffDepartmentId}/base")
    @Produces(MediaType.APPLICATION_JSON)
    public StaffDepartmentBase getStaffDepartmentBaseById(@PathParam("staffDepartmentId") UUID staffDepartmentId) {
        return this.staffDepartmentService.getStaffDepartmentBaseById(staffDepartmentId);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDepartment(StaffDepartmentBase staffDepartmentBase) {
        this.staffDepartmentService.addStaffDepartment(staffDepartmentBase);
    }

    @PUT
    @Path("/{staffDepartmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDepartment(
            @PathParam("staffDepartmentId") UUID staffDepartmentId,
            StaffDepartmentBase udpatedStaffDepartmentBase) {
        this.staffDepartmentService.updateStaffDepartment(staffDepartmentId, udpatedStaffDepartmentBase);
    }

}
