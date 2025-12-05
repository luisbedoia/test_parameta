package com.example.helloworld.api;

import java.time.OffsetDateTime;
import java.util.LinkedHashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.helloworld.api.dto.EmployeeRequest;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/empleados")
@Validated
public class EmployeeController {

    @GetMapping
    public ResponseEntity<Map<String, Object>> validarEmpleado(@Valid @ModelAttribute EmployeeRequest request) {
        Map<String, Object> body = new LinkedHashMap<>();
        body.put("mensaje", "Validacion exitosa");
        body.put("timestamp", OffsetDateTime.now().toString());
        body.put("empleado", request);
        return ResponseEntity.ok(body);
    }
}
