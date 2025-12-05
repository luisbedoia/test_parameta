package com.example.helloworld.api.dto;

import java.time.LocalDate;

public class EmployeeResponse {

  private String firstName;
  private String lastName;
  private String documentType;
  private String documentNumber;
  private LocalDate birthDate;
  private LocalDate companyEntryDate;
  private String position;
  private Double salary;
  private PeriodSummary currentAge;
  private PeriodSummary companyTenure;
  private String registrationMessage;
  private Long recordId;

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

  public PeriodSummary getCurrentAge() {
    return currentAge;
  }

  public void setCurrentAge(PeriodSummary currentAge) {
    this.currentAge = currentAge;
  }

  public PeriodSummary getCompanyTenure() {
    return companyTenure;
  }

  public void setCompanyTenure(PeriodSummary companyTenure) {
    this.companyTenure = companyTenure;
  }

  public String getRegistrationMessage() {
    return registrationMessage;
  }

  public void setRegistrationMessage(String registrationMessage) {
    this.registrationMessage = registrationMessage;
  }

  public Long getRecordId() {
    return recordId;
  }

  public void setRecordId(Long recordId) {
    this.recordId = recordId;
  }
}
