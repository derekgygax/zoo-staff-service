package local.zoo.staffservice.repository;

import java.util.List;
import java.util.UUID;

import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;
import local.zoo.staffservice.dto.department.DepartmentBase;
import local.zoo.staffservice.dto.department.DepartmentIdentifier;
import local.zoo.staffservice.model.Department;

@ApplicationScoped
public class DepartmentRepository implements PanacheRepositoryBase<Department, UUID> {

    public List<DepartmentIdentifier> findAllIdentifiers() {
        return this.getEntityManager()
                .createQuery("SELECT d.id, d.name from Department d", DepartmentIdentifier.class)
                .getResultList();
    }

    public DepartmentBase findDepartmentBaseById(UUID id) {
        return this.getEntityManager()
                .createQuery(
                        "SELECT new DepartmentBase(" +
                                "d.name, d.description) "
                                +
                                "FROM Department d WHERE d.id = :id",
                        DepartmentBase.class)
                .setParameter("id", id)
                .getSingleResult();
    }
}
