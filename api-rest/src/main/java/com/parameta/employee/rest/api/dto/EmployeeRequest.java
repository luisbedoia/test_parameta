package com.parameta.employee.rest.api.dto;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import java.time.LocalDate;
import java.time.Period;
import org.springframework.format.annotation.DateTimeFormat;

public class EmployeeRequest {

  @NotBlank(message = "First name is required")
  private String firstName;

  @NotBlank(message = "Last name is required")
  private String lastName;

  @NotBlank(message = "Document type is required")
  private String documentType;

  @NotBlank(message = "Document number is required")
  private String documentNumber;

  @NotNull(message = "Birth date is required")
  @Past(message = "Birth date must be in the past")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate birthDate;

  @NotNull(message = "Company entry date is required")
  @PastOrPresent(message = "Company entry date cannot be in the future")
  @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
  private LocalDate companyEntryDate;

  @NotBlank(message = "Position is required")
  private String position;

  @NotNull(message = "Salary is required")
  @Positive(message = "Salary must be positive")
  private Double salary;

  @AssertTrue(message = "Employee must be of legal age")
  public boolean isAdult() {
    if (birthDate == null) {
      return false;
    }
    // Ensure the calculation fails fast when the birthday is missing.
    return Period.between(birthDate, LocalDate.now()).getYears() >= 18;
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

  public String getDocumentType() {
    return documentType;
  }

  public void setDocumentType(String documentType) {
    this.documentType = documentType;
  }

  public String getDocumentNumber() {
    return documentNumber;
  }

  public void setDocumentNumber(String documentNumber) {
    this.documentNumber = documentNumber;
  }

  public LocalDate getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(LocalDate birthDate) {
    this.birthDate = birthDate;
  }

  public LocalDate getCompanyEntryDate() {
    return companyEntryDate;
  }

  public void setCompanyEntryDate(LocalDate companyEntryDate) {
    this.companyEntryDate = companyEntryDate;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public Double getSalary() {
    return salary;
  }

  public void setSalary(Double salary) {
    this.salary = salary;
  }
}
