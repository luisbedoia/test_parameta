package com.example.helloworld.api;

import java.time.OffsetDateTime;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/hello")
public class GreetingController {

    @GetMapping
    public ResponseEntity<Map<String, String>> hello(@RequestParam(defaultValue = "Mundo") String nombre) {
        Map<String, String> body = Map.of(
                "mensaje", "Hola " + nombre + "!",
                "timestamp", OffsetDateTime.now().toString());
        return ResponseEntity.ok(body);
    }
}
