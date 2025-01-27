package local.zoo.staffservice.repository;

import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import local.zoo.staffservice.dto.staffdepartment.StaffDepartmentBase;
import local.zoo.staffservice.model.StaffDepartment;

@ApplicationScoped
public class StaffDepartmentRepository implements PanacheRepositoryBase<StaffDepartment, UUID> {

    public StaffDepartmentBase findStaffDepartmentBaseById(UUID id) {
        return this.getEntityManager()
                .createQuery(
                        "SELECT new StaffDepartmentBase(" +
                                "sd.staff.id, sd.department.id, sd.role) "
                                +
                                "FROM StaffDepartment sd WHERE sd.id = :id",
                        StaffDepartmentBase.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
