package com.example.helloworld.api.dto;

import java.time.LocalDate;
import java.time.Period;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.AssertTrue;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Past;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;

public class EmployeeRequest {

    @NotBlank(message = "El nombre es obligatorio")
    private String nombres;

    @NotBlank(message = "El apellido es obligatorio")
    private String apellidos;

    @NotBlank(message = "El tipo de documento es obligatorio")
    private String tipoDocumento;

    @NotBlank(message = "El numero de documento es obligatorio")
    private String numeroDocumento;

    @NotNull(message = "La fecha de nacimiento es obligatoria")
    @Past(message = "La fecha de nacimiento debe estar en el pasado")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaNacimiento;

    @NotNull(message = "La fecha de vinculacion es obligatoria")
    @PastOrPresent(message = "La fecha de vinculacion no puede estar en el futuro")
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate fechaVinculacionCompania;

    @NotBlank(message = "El cargo es obligatorio")
    private String cargo;

    @NotNull(message = "El salario es obligatorio")
    @Positive(message = "El salario debe ser positivo")
    private Double salario;

    @AssertTrue(message = "El empleado debe ser mayor de edad")
    public boolean isMayorEdad() {
        if (fechaNacimiento == null) {
            return false;
        }
        // Ensure the calculation fails fast when the birthday is missing.
        return Period.between(fechaNacimiento, LocalDate.now()).getYears() >= 18;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getNumeroDocumento() {
        return numeroDocumento;
    }

    public void setNumeroDocumento(String numeroDocumento) {
        this.numeroDocumento = numeroDocumento;
    }

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public LocalDate getFechaVinculacionCompania() {
        return fechaVinculacionCompania;
    }

    public void setFechaVinculacionCompania(LocalDate fechaVinculacionCompania) {
        this.fechaVinculacionCompania = fechaVinculacionCompania;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }
}
