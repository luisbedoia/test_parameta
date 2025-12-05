package com.parameta.employee.rest.api.config;

import com.parameta.employee.rest.api.soap.schema.EmployeeRegistrationRequest;
import com.parameta.employee.rest.api.soap.schema.EmployeeRegistrationResponse;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class SoapClientConfig {

  @Bean
  public Jaxb2Marshaller employeeMarshaller() {
    Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
    marshaller.setClassesToBeBound(
        EmployeeRegistrationRequest.class, EmployeeRegistrationResponse.class);
    return marshaller;
  }

  @Bean
  public WebServiceTemplate employeeWebServiceTemplate(
      Jaxb2Marshaller employeeMarshaller,
      @Value("${employee.soap.url:http://localhost:8081/ws}") String soapUrl) {
    WebServiceTemplate template = new WebServiceTemplate();
    template.setMarshaller(employeeMarshaller);
    template.setUnmarshaller(employeeMarshaller);
    template.setDefaultUri(soapUrl);
    return template;
  }
}
