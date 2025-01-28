package local.zoo.staffservice.service;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import local.zoo.staffservice.dto.ModelIdentifier;
import local.zoo.staffservice.dto.staffdepartment.StaffDepartmentBase;
import local.zoo.staffservice.model.Department;
import local.zoo.staffservice.model.Staff;
import local.zoo.staffservice.model.StaffDepartment;
import local.zoo.staffservice.repository.StaffDepartmentRepository;

@ApplicationScoped
public class StaffDepartmentService {

    @Inject
    StaffService staffService;

    @Inject
    DepartmentService departmentService;

    @Inject
    StaffDepartmentRepository staffDepartmentRepository;

    public StaffDepartment getStaffDepartmentById(UUID staffDepartmentId) {
        StaffDepartment staffDepartment = this.staffDepartmentRepository.findById(staffDepartmentId);
        if (staffDepartment == null) {
            throw new EntityNotFoundException(
                    "The comnination of the Staff member and the Department not found with the ID: "
                            + staffDepartmentId);
        }
        return staffDepartment;
    }

    public StaffDepartmentBase getStaffDepartmentBaseById(UUID staffDepartmentId) {
        StaffDepartmentBase staffDepartmentBase = this.staffDepartmentRepository
                .findStaffDepartmentBaseById(staffDepartmentId);
        if (staffDepartmentBase == null) {
            throw new EntityNotFoundException(
                    "The comnination of the Staff member and the Department not found with the ID: "
                            + staffDepartmentId);
        }
        return staffDepartmentBase;
    }

    public List<StaffDepartment> getAllStaffDepartments() {
        return this.staffDepartmentRepository.listAll();
    }

    public List<ModelIdentifier> getAllStaffDepartmentIdentifiers() {
        List<StaffDepartment> staffDepartments = getAllStaffDepartments();

        List<ModelIdentifier> modelIdentifiers = staffDepartments.stream()
                .map((StaffDepartment staffDeparment) -> {
                    return staffDeparment.getModelIdentifier();
                }).toList();

        return modelIdentifiers;
    }

    @Transactional
    public void addStaffDepartment(StaffDepartmentBase staffDepartmentBase) {
        // get the staff and the department from the ids in staffDepartmentBase
        Department department = this.departmentService.getDepartmentById(staffDepartmentBase.departmentId());
        Staff staff = this.staffService.getStaffById(staffDepartmentBase.staffId());

        StaffDepartment staffDepartment = new StaffDepartment(
                department,
                staff,
                staffDepartmentBase.role());

        this.staffDepartmentRepository.persist(staffDepartment);
    }

    @Transactional
    public void updateStaffDepartment(UUID staffDepartmentId, StaffDepartmentBase updatedStaffDepartment) {

        StaffDepartment existingStaffDepartment = getStaffDepartmentById(staffDepartmentId);

        Department department = this.departmentService.getDepartmentById(updatedStaffDepartment.departmentId());
        Staff staff = this.staffService.getStaffById(updatedStaffDepartment.staffId());

        existingStaffDepartment.setDepartment(department);
        existingStaffDepartment.setStaff(staff);
        existingStaffDepartment.setRole(updatedStaffDepartment.role());

        this.staffDepartmentRepository.persist(existingStaffDepartment);
    }

}
