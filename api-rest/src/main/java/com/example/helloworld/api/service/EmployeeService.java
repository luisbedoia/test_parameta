package com.example.helloworld.api.service;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.stereotype.Service;
import com.example.helloworld.api.dto.EmployeeRequest;
import com.example.helloworld.api.dto.EmployeeResponse;
import com.example.helloworld.api.dto.PeriodSummary;
import com.example.helloworld.api.soap.EmployeeRegistrationClient;
import com.example.helloworld.api.soap.schema.EmployeeRegistrationResponse;

@Service
public class EmployeeService {

    private final EmployeeRegistrationClient soapClient;

    public EmployeeService(EmployeeRegistrationClient soapClient) {
        this.soapClient = soapClient;
    }

    public EmployeeResponse process(EmployeeRequest request) {
        EmployeeRegistrationResponse soapResponse = soapClient.registerEmployee(request);

        EmployeeResponse response = new EmployeeResponse();
        response.setFirstName(request.getFirstName());
        response.setLastName(request.getLastName());
        response.setDocumentType(request.getDocumentType());
        response.setDocumentNumber(request.getDocumentNumber());
        response.setBirthDate(request.getBirthDate());
        response.setCompanyEntryDate(request.getCompanyEntryDate());
        response.setPosition(request.getPosition());
        response.setSalary(request.getSalary());
        response.setCurrentAge(asSummary(Period.between(request.getBirthDate(), LocalDate.now())));
        response.setCompanyTenure(asSummary(Period.between(request.getCompanyEntryDate(), LocalDate.now())));
        response.setRegistrationMessage(soapResponse.getMessage());
        response.setRecordId(soapResponse.getRecordId());
        return response;
    }

    private PeriodSummary asSummary(Period period) {
        return new PeriodSummary(period.getYears(), period.getMonths(), period.getDays());
    }
}
