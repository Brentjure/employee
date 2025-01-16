package com.brent.employees.dto;

import com.brent.employees.entity.EmployeeEntity;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeResponseBody implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @Valid
    @JsonProperty("employee")
    private EmployeeEntity employee;

    @JsonProperty("employeeStatus")
    private String employeeStatus;

    @JsonProperty("message")
    private String message;

    public EmployeeResponseBody(@Valid EmployeeEntity employeeEntity, String employeeStatus, String message) {
        this.employee = employeeEntity;
        this.employeeStatus = employeeStatus;
        this.message = message;
    }

    // Add getter for employee field
    public EmployeeEntity getEmployee() {
        return employee; }

    @Override
    public String toString() {
        return "EmployeeResponseBody{" +
                "employee=" + employee +
                ", employeeStatus='" +
                employeeStatus + '\'' + ", message='" + message + '\'' + '}'; }

}

