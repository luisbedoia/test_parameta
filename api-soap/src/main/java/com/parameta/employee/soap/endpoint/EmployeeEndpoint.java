package com.parameta.employee.soap.endpoint;

import com.parameta.employee.soap.model.EmployeeRegistrationRequest;
import com.parameta.employee.soap.model.EmployeeRegistrationResponse;
import com.parameta.employee.soap.service.EmployeeRegistrationService;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

@Endpoint
public class EmployeeEndpoint {

  public static final String NAMESPACE_URI = EmployeeRegistrationRequest.NAMESPACE_URI;

  private final EmployeeRegistrationService registrationService;

  public EmployeeEndpoint(EmployeeRegistrationService registrationService) {
    this.registrationService = registrationService;
  }

  @PayloadRoot(namespace = NAMESPACE_URI, localPart = "EmployeeRegistrationRequest")
  @ResponsePayload
  public EmployeeRegistrationResponse registerEmployee(
      @RequestPayload EmployeeRegistrationRequest request) {
    Long recordId = registrationService.registerEmployee(request);

    EmployeeRegistrationResponse response = new EmployeeRegistrationResponse();
    response.setMessage("Employee stored successfully");
    response.setRecordId(recordId == null ? 0L : recordId);
    return response;
  }
}
