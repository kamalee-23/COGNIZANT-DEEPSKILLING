package com.cognizant.employeeorm;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import com.cognizant.employeeorm.model.Employee;
import com.cognizant.employeeorm.service.EmployeeService;

@SpringBootApplication
public class EmployeeOrmApplication {

    private static final Logger LOGGER =
            LoggerFactory.getLogger(EmployeeOrmApplication.class);

    private static EmployeeService employeeService;

    public static void main(String[] args) {

        ApplicationContext context =
                SpringApplication.run(EmployeeOrmApplication.class, args);

        employeeService = context.getBean(EmployeeService.class);

        showEmployees();

        LOGGER.info("Application Executed Successfully");

    }

    private static void showEmployees() {

        LOGGER.info("Employee Details");

        List<Employee> employees = employeeService.getAllEmployees();

        for (Employee employee : employees) {
            LOGGER.info(employee.toString());
        }

    }

}