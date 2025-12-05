package com.parameta.employee.soap.model;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
    name = "GreetingRequest",
    propOrder = {"name"})
@XmlRootElement(name = "GreetingRequest", namespace = "http://parameta.com/soap/greeting")
public class GreetingRequest {

  @XmlElement(required = false)
  private String name;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
