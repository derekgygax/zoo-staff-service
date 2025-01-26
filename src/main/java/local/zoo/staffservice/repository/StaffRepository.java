package local.zoo.staffservice.repository;

import jakarta.enterprise.context.ApplicationScoped;
import local.zoo.staffservice.dto.staff.StaffBase;
import local.zoo.staffservice.dto.staff.StaffIdentifier;
import local.zoo.staffservice.model.Staff;

import java.util.List;
import java.util.UUID;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;

@ApplicationScoped
public class StaffRepository implements PanacheRepositoryBase<Staff, UUID> {

    public List<StaffIdentifier> findAllIdentifiers() {
        return this.getEntityManager()
                .createQuery("SELECT s.id, s.firstName, s.lastName from Staff s", StaffIdentifier.class)
                .getResultList();
    }

    public StaffBase findStaffBaseById(UUID id) {
        return this.getEntityManager()
                .createQuery(
                        "SELECT new StaffBase(" +
                                "s.firstName, s.lastName, s.title, s.email, s.phoneNumber, s.hireDate, s.startDate) "
                                +
                                "FROM Staff s WHERE s.id = :id",
                        StaffBase.class)
                .setParameter("id", id)
                .getSingleResult();
    }

}
