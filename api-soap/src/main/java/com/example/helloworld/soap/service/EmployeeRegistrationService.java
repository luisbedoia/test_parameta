package com.example.helloworld.soap.service;

import com.example.helloworld.soap.model.EmployeeRegistrationRequest;
import com.example.helloworld.soap.persistence.EmployeeEntity;
import com.example.helloworld.soap.persistence.EmployeeRepository;
import java.time.LocalDate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class EmployeeRegistrationService {

  private final EmployeeRepository employeeRepository;

  public EmployeeRegistrationService(EmployeeRepository employeeRepository) {
    this.employeeRepository = employeeRepository;
  }

  @Transactional
  public Long registerEmployee(EmployeeRegistrationRequest request) {
    EmployeeEntity entity =
        employeeRepository
            .findByDocumentTypeAndDocumentNumber(
                request.getDocumentType(), request.getDocumentNumber())
            .orElseGet(EmployeeEntity::new);

    entity.setFirstName(request.getFirstName());
    entity.setLastName(request.getLastName());
    entity.setDocumentType(request.getDocumentType());
    entity.setDocumentNumber(request.getDocumentNumber());
    entity.setBirthDate(toLocalDate(request.getBirthDate()));
    entity.setCompanyEntryDate(toLocalDate(request.getCompanyEntryDate()));
    entity.setPosition(request.getPosition());
    entity.setSalary(request.getSalary());

    EmployeeEntity saved = employeeRepository.save(entity);
    return saved.getId();
  }

  private LocalDate toLocalDate(javax.xml.datatype.XMLGregorianCalendar calendar) {
    return calendar == null ? null : calendar.toGregorianCalendar().toZonedDateTime().toLocalDate();
  }
}
