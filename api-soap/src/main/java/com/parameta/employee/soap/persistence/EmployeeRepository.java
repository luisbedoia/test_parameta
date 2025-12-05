package com.parameta.employee.soap.persistence;

import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EmployeeRepository extends JpaRepository<EmployeeEntity, Long> {

  Optional<EmployeeEntity> findByDocumentTypeAndDocumentNumber(
      String documentType, String documentNumber);
}
