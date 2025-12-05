package com.example.helloworld.soap.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "EmployeeRegistrationResponse",
    propOrder = {"message", "recordId"})
@XmlRootElement(
    name = "EmployeeRegistrationResponse",
    namespace = EmployeeRegistrationRequest.NAMESPACE_URI)
public class EmployeeRegistrationResponse {

  @XmlElement(required = true)
  private String message;

  @XmlElement(required = true)
  private long recordId;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public long getRecordId() {
    return recordId;
  }

  public void setRecordId(long recordId) {
    this.recordId = recordId;
  }
}
