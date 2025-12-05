package com.parameta.employee.rest.api.soap;

import com.parameta.employee.rest.api.dto.EmployeeRequest;
import com.parameta.employee.rest.api.soap.schema.EmployeeRegistrationRequest;
import com.parameta.employee.rest.api.soap.schema.EmployeeRegistrationResponse;
import java.math.BigDecimal;
import java.time.LocalDate;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;
import org.springframework.stereotype.Component;
import org.springframework.ws.client.core.WebServiceTemplate;

@Component
public class EmployeeRegistrationClient {

  private final WebServiceTemplate webServiceTemplate;

  public EmployeeRegistrationClient(WebServiceTemplate webServiceTemplate) {
    this.webServiceTemplate = webServiceTemplate;
  }

  public EmployeeRegistrationResponse registerEmployee(EmployeeRequest request) {
    EmployeeRegistrationRequest soapRequest = new EmployeeRegistrationRequest();
    soapRequest.setFirstName(request.getFirstName());
    soapRequest.setLastName(request.getLastName());
    soapRequest.setDocumentType(request.getDocumentType());
    soapRequest.setDocumentNumber(request.getDocumentNumber());
    soapRequest.setBirthDate(toXmlDate(request.getBirthDate()));
    soapRequest.setCompanyEntryDate(toXmlDate(request.getCompanyEntryDate()));
    soapRequest.setPosition(request.getPosition());
    soapRequest.setSalary(BigDecimal.valueOf(request.getSalary()));

    Object response = webServiceTemplate.marshalSendAndReceive(soapRequest);
    if (response instanceof EmployeeRegistrationResponse soapResponse) {
      return soapResponse;
    }
    throw new IllegalStateException("Received an unknown SOAP response");
  }

  private XMLGregorianCalendar toXmlDate(LocalDate date) {
    try {
      return DatatypeFactory.newInstance().newXMLGregorianCalendar(date.toString());
    } catch (DatatypeConfigurationException ex) {
      throw new IllegalStateException("Failed to convert date to XMLGregorianCalendar", ex);
    }
  }
}
