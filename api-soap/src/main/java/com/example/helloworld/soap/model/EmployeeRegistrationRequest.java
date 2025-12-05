package com.example.helloworld.soap.model;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;
import java.math.BigDecimal;
import javax.xml.datatype.XMLGregorianCalendar;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "EmployeeRegistrationRequest",
    propOrder = {
      "firstName",
      "lastName",
      "documentType",
      "documentNumber",
      "birthDate",
      "companyEntryDate",
      "position",
      "salary"
    })
@XmlRootElement(
    name = "EmployeeRegistrationRequest",
    namespace = EmployeeRegistrationRequest.NAMESPACE_URI)
public class EmployeeRegistrationRequest {

  public static final String NAMESPACE_URI = "http://example.com/parameta/employee";

  @XmlElement(required = true)
  @NotBlank
  private String firstName;

  @XmlElement(required = true)
  @NotBlank
  private String lastName;

  @XmlElement(required = true)
  @NotBlank
  private String documentType;

  @XmlElement(required = true)
  @NotBlank
  private String documentNumber;

  @XmlElement(required = true)
  @NotNull
  private XMLGregorianCalendar birthDate;

  @XmlElement(required = true)
  @NotNull
  private XMLGregorianCalendar companyEntryDate;

  @XmlElement(required = true)
  @NotBlank
  private String position;

  @XmlElement(required = true)
  @NotNull
  @DecimalMin(value = "0.0", inclusive = false)
  private BigDecimal salary;

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

  public XMLGregorianCalendar getBirthDate() {
    return birthDate;
  }

  public void setBirthDate(XMLGregorianCalendar birthDate) {
    this.birthDate = birthDate;
  }

  public XMLGregorianCalendar getCompanyEntryDate() {
    return companyEntryDate;
  }

  public void setCompanyEntryDate(XMLGregorianCalendar companyEntryDate) {
    this.companyEntryDate = companyEntryDate;
  }

  public String getPosition() {
    return position;
  }

  public void setPosition(String position) {
    this.position = position;
  }

  public BigDecimal getSalary() {
    return salary;
  }

  public void setSalary(BigDecimal salary) {
    this.salary = salary;
  }
}
