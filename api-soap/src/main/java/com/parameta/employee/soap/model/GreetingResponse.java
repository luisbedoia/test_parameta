package com.parameta.employee.soap.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "GreetingResponse",
    propOrder = {"message", "timestamp"})
@XmlRootElement(name = "GreetingResponse", namespace = "http://parameta.com/soap/greeting")
public class GreetingResponse {

  @XmlElement(required = true)
  private String message;

  @XmlElement(required = true)
  private String timestamp;

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public String getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(String timestamp) {
    this.timestamp = timestamp;
  }
}
