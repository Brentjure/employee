package com.brent.employees.dto;

import jakarta.validation.constraints.Size;
import lombok.Data;
import org.antlr.v4.runtime.misc.NotNull;

@Data
public class EmployeeRequestBody {
    @NotNull
    @Size(min = 2, max = 50, message = "First name must be between 2 and 50 characters")
    String first_name;
    @NotNull
    String last_name;
    @NotNull
    String email;
    @NotNull
    String  gender;
    @NotNull
    String  position;

    @Override
    public String toString() {
        return "EmployeeRequestBody{" +
                "firstName='" + first_name + '\'' +
                ", lastName='" + last_name + '\'' +
                ", email='" + email + '\'' +
                ", gender='" + gender + '\'' +
                ", position='" + position + '\'' +
                '}';
    }
}
//first_name VARCHAR(50) NOT NULL,
//last_name VARCHAR(50) NOT NULL,
//email VARCHAR(100) UNIQUE NOT NULL,
//gender VARCHAR(45) NOT NULL,
//position VARCHAR(445) NOT NULL

