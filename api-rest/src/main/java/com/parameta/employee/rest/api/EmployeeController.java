package com.parameta.employee.rest.api;

import com.parameta.employee.rest.api.dto.EmployeeRequest;
import com.parameta.employee.rest.api.dto.EmployeeResponse;
import com.parameta.employee.rest.api.service.EmployeeService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/employees")
@Validated
public class EmployeeController {

  private final EmployeeService employeeService;

  public EmployeeController(EmployeeService employeeService) {
    this.employeeService = employeeService;
  }

  @GetMapping
  public ResponseEntity<EmployeeResponse> validateEmployee(
      @Valid @ModelAttribute EmployeeRequest request) {
    EmployeeResponse response = employeeService.process(request);
    return ResponseEntity.ok(response);
  }
}
