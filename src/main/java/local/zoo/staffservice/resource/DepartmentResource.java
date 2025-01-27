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
import local.zoo.staffservice.dto.department.DepartmentBase;
import local.zoo.staffservice.dto.department.DepartmentIdentifier;
import local.zoo.staffservice.model.Department;
import local.zoo.staffservice.service.DepartmentService;

@Path("/api/v1/departments")
public class DepartmentResource {

    @Inject
    DepartmentService departmentService;

    @GET
    @Path("/")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Department> getAllDepartmentes() {
        return departmentService.getAllDepartments();
    }

    @GET
    @Path("/identifiers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DepartmentIdentifier> getAllDepartmentIdentifiers() {
        return this.departmentService.getAllDepartmentIdentifiers();
    }

    @GET
    @Path("/{departmentId}/base")
    @Produces(MediaType.APPLICATION_JSON)
    public DepartmentBase getDepartmentBaseById(@PathParam("departmentId") UUID departmentId) {
        return this.departmentService.getDepartmentBaseById(departmentId);
    }

    @POST
    @Path("/")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDepartment(DepartmentBase departmentBase) {
        this.departmentService.addDepartment(departmentBase);
    }

    @PUT
    @Path("/{departmentId}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateDepartment(@PathParam("departmentId") UUID departmentId, DepartmentBase updatedDepartmentBase) {
        this.departmentService.updateDepartment(departmentId, updatedDepartmentBase);
    }
}
