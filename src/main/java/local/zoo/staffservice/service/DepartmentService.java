package local.zoo.staffservice.service;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import local.zoo.staffservice.dto.department.DepartmentBase;
import local.zoo.staffservice.dto.department.DepartmentIdentifier;
import local.zoo.staffservice.model.Department;
import local.zoo.staffservice.repository.DepartmentRepository;

@ApplicationScoped
public class DepartmentService {

    @Inject
    DepartmentRepository departmentRepository;

    public Department getDepartmentById(UUID departmentID) {
        Department department = this.departmentRepository.findById(departmentID);
        if (department == null) {
            throw new EntityNotFoundException("Department not found with the ID: " + departmentID);
        }
        return department;
    }

    public DepartmentBase getDepartmentBaseById(UUID departmentID) {
        DepartmentBase department = this.departmentRepository.findDepartmentBaseById(departmentID);
        if (department == null) {
            throw new EntityNotFoundException("Department not found with the ID: " + departmentID);
        }
        return department;
    }

    public List<Department> getAllDepartments() {
        return this.departmentRepository.listAll();
    }

    public List<DepartmentIdentifier> getAllDepartmentIdentifiers() {
        return this.departmentRepository.findAllIdentifiers();
    }

    @Transactional
    public void addDepartment(DepartmentBase departmentBase) {
        Department department = new Department(departmentBase);
        this.departmentRepository.persist(department);
    }

    @Transactional
    public void updateDepartment(UUID departmentId, DepartmentBase updatedDepartmentBase) {

        // get the existing department
        Department existingDepartment = getDepartmentById(departmentId);

        // set the new values
        existingDepartment.setName(updatedDepartmentBase.name());
        existingDepartment.setDescription(updatedDepartmentBase.description());

        // persist just means put into hibernate memory and save
        this.departmentRepository.persist(existingDepartment);
    }
}
