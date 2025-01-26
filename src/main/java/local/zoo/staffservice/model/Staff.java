package local.zoo.staffservice.model;

import java.time.Instant;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Pattern;
import local.zoo.staffservice.dto.staff.StaffBase;
import local.zoo.staffservice.enums.Title;

@Entity
@Table(name = "staff")
public class Staff {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false, unique = true, updatable = false)
    private UUID id;

    @Column(name = "first_name", nullable = false, length = 100)
    private String firstName;

    @Column(name = "last_name", nullable = false, length = 100)
    private String lastName;

    @Column(name = "title", nullable = false)
    @Enumerated(EnumType.STRING)
    private Title title;

    @Email
    @Column(name = "email", nullable = false, length = 250, unique = true)
    private String email;

    @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid phone number format")
    @Column(name = "phone_number", nullable = false, length = 15, unique = true)
    private String phoneNumber;

    @Column(name = "hire_date", nullable = false, columnDefinition = "DATE")
    private LocalDate hireDate;

    @Column(name = "start_date", nullable = false, columnDefinition = "DATE")
    private LocalDate startDate;

    @CreationTimestamp
    @Column(name = "created_at", nullable = false, updatable = false, columnDefinition = "TIMESTAMP WITH TIME ZONE")
    // Use Instant for UTC timestamps
    private Instant createdAt;

    @UpdateTimestamp
    @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
    // Use Instant for UTC timestamps
    private Instant updatedAt;

    @OneToMany(mappedBy = "staff", cascade = { CascadeType.ALL }, orphanRemoval = true)
    @JsonIgnore
    private List<StaffDepartment> staffDepartments;

    public Staff() {
    }

    public Staff(
            String firstName,
            String lastName,
            @Email String email,
            @Pattern(regexp = "^\\+?[1-9]\\d{1,14}$", message = "Invalid phone number format") String phoneNumber,
            Title title,
            LocalDate hireDate,
            LocalDate startDate) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.title = title;
        this.hireDate = hireDate;
        this.startDate = startDate;
    }

    public Staff(StaffBase staffBase) {
        this.firstName = staffBase.firstName();
        this.lastName = staffBase.lastName();
        this.email = staffBase.email();
        this.phoneNumber = staffBase.phoneNumber();
        this.title = staffBase.title();
        this.hireDate = staffBase.hireDate();
        this.startDate = staffBase.startDate();
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Title getTitle() {
        return title;
    }

    public void setTitle(Title title) {
        this.title = title;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Instant createdAt) {
        this.createdAt = createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }

    public List<StaffDepartment> getStaffDepartments() {
        return staffDepartments;
    }

    public void setStaffDepartments(List<StaffDepartment> staffDepartments) {
        this.staffDepartments = staffDepartments;
    }

    @Override
    public String toString() {
        return "Staff [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", title=" + title
                + ", email=" + email + ", phoneNumber=" + phoneNumber + ", hireDate=" + hireDate + ", startDate="
                + startDate + ", createdAt=" + createdAt + ", updatedAt=" + updatedAt + ", staffDepartments="
                + staffDepartments + "]";
    }

}