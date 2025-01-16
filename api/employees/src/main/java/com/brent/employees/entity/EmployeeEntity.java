package com.brent.employees.entity;


import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;

@Entity
@AllArgsConstructor
@Data
@Table(name = "employee_details")
public class EmployeeEntity  {
    //private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    @JsonProperty("id")
    private int id;

    @Column(name = "first_name")
    @JsonProperty("first_name")
    private String first_name;

    @Column(name = "last_name")
    @JsonProperty("last_name")
    private String last_name;

    @Column(name = "email")
    @JsonProperty("email")
    private String email;

    @Column(name="gender")
    @JsonProperty("gender")
    private String gender;

    @Column(name="position")
    @JsonProperty("position")
    private String position;

    public EmployeeEntity(){}

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
