package local.zoo.staffservice.service;

import java.util.List;
import java.util.UUID;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import local.zoo.staffservice.dto.staff.StaffBase;
import local.zoo.staffservice.dto.staff.StaffIdentifier;
import local.zoo.staffservice.model.Staff;
import local.zoo.staffservice.repository.StaffRepository;

@ApplicationScoped
public class StaffService {

    @Inject
    StaffRepository staffRepository;

    // Get the Staff by ID from the DB
    public Staff getStaffById(UUID staffId) {
        Staff staff = this.staffRepository.findById(staffId);
        if (staff == null) {
            throw new EntityNotFoundException("Staff member not found with the ID: " + staffId);
        }
        return staff;
    }

    public StaffBase getStaffBaseById(UUID staffId) {
        StaffBase staffBase = this.staffRepository.findStaffBaseById(staffId);
        return staffBase;
    }

    public List<Staff> getAllStaff() {
        return staffRepository.listAll();
    }

    public List<StaffIdentifier> getAllStaffIdentifiers() {
        return staffRepository.findAllIdentifiers();
    }

    // Add a new staff member
    @Transactional
    public void addStaff(StaffBase staffBase) {
        Staff staff = new Staff(staffBase);
        this.staffRepository.persist(staff);
    }

    @Transactional
    public void updateStaff(UUID staffId, StaffBase staffBase) {

        // Get the existing staff
        Staff existingStaff = getStaffById(staffId);

        // Set the new values
        existingStaff.setFirstName(staffBase.firstName());
        existingStaff.setLastName(staffBase.lastName());
        existingStaff.setTitle(staffBase.title());
        existingStaff.setEmail(staffBase.email());
        existingStaff.setPhoneNumber(staffBase.phoneNumber());
        existingStaff.setHireDate(staffBase.hireDate());
        existingStaff.setStartDate(staffBase.startDate());

        // persist just means put into hibernate memory and save
        this.staffRepository.persist(existingStaff);

    }
}
