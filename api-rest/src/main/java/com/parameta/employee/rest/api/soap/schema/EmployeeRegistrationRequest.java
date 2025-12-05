package com.parameta.employee.rest.api.soap.schema;

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

  public static final String NAMESPACE_URI = "http://parameta.com/employee";

  @XmlElement(required = true)
  private String firstName;

  @XmlElement(required = true)
  private String lastName;

  @XmlElement(required = true)
  private String documentType;

  @XmlElement(required = true)
  private String documentNumber;

  @XmlElement(required = true)
  private XMLGregorianCalendar birthDate;

  @XmlElement(required = true)
  private XMLGregorianCalendar companyEntryDate;

  @XmlElement(required = true)
  private String position;

  @XmlElement(required = true)
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
