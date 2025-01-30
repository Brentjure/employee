package com.brent.employees.controller;

import com.brent.employees.config.RabbitMQConfig;
import com.brent.employees.dto.EmployeeRequestBody;
import com.brent.employees.dto.EmployeeResponseBody;
import com.brent.employees.entity.EmployeeEntity;
import com.brent.employees.repository.EmployeeRepo;
import jakarta.validation.Valid;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/v1")
public class EmployeeController {

    @Autowired
    EmployeeRepo employeeRepo;

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @PostMapping("/post-employee-details")
    public EmployeeResponseBody postEmpoyeeDetails(@RequestBody @Valid EmployeeEntity employeeEntity){
        System.out.println(employeeEntity);

        EmployeeResponseBody employeeResponseBody = new EmployeeResponseBody(employeeEntity, "Details submitted", "Your details have been summited!!!");

        rabbitTemplate.convertAndSend(RabbitMQConfig.EXCANGE, RabbitMQConfig.ROUTING_KEY, employeeResponseBody);
        System.out.println("employeeResponseBody" +employeeResponseBody);
        return employeeResponseBody;



    }


    @GetMapping("/get-all-employees")
    public List<EmployeeEntity> getAllEmployees(){

        return employeeRepo.findAll();
    }

    @GetMapping("/test-employees")
    public List<EmployeeEntity> testEmployees() {
        List<EmployeeEntity> employees = employeeRepo.findAll();
        for (EmployeeEntity employee : employees) {
            System.out.println(employee);
        }
        return employees;

    }



}
