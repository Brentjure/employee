package com.brent.employees.consumer;

import com.brent.employees.config.RabbitMQConfig;
import com.brent.employees.dto.EmployeeResponseBody;
import com.brent.employees.entity.EmployeeEntity;
import com.brent.employees.repository.EmployeeRepo;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Component;

@Component
public class Consumer {

    @Autowired
    EmployeeRepo employeeRepo;

    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void comsume(EmployeeResponseBody employeeResponseBody){
        System.out.println(" consumer is able to consume message from the queues " + employeeResponseBody);

        // Extract the EmployeeEntity from EmployeeResponseBody
        EmployeeEntity employeeEntity = employeeResponseBody.getEmployee();

        try {
            // Save the EmployeeEntity to the database
            employeeRepo.save(employeeEntity);
            System.out.println("\nSaved employee entity to the database: " + employeeEntity);

        } catch (DataIntegrityViolationException e){

            // Handle duplicate email exception
            System.err.println("Error saving employee: Email already exists.");
            //System.err.println("Duplicate email: " + employeeEntity.getEmail());
        }




    }
}
