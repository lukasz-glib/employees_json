package pl.lg.employeesjson.employees.service;

import pl.lg.employeesjson.employees.domain.entities.Employee;

public interface EmployService {

    Iterable<Employee> list();

    void saveFromJson();

    Double sumOfSalaryForTeacher();

    Double sumOfSalaryForPriest();

    Double sumOfSalaryForJanitor();
}
