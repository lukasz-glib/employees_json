package pl.lg.employeesjson.employees.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import pl.lg.employeesjson.employees.domain.entities.Employee;
import pl.lg.employeesjson.employees.service.EmployService;

@RestController
@RequestMapping("/employees")
public class EmployeesController {

    private final EmployService employService;

    public EmployeesController(EmployService employService) {
        this.employService = employService;
    }

    @ResponseBody
    @GetMapping("/add")
    public String getDataFromJson () {
        employService.saveFromJson();
        return "---";
    }

    @GetMapping("/list")
    public Iterable<Employee> list() {
        return employService.list();
    }

    @GetMapping("/sum-of-salary-for-teacher")
    public Double sumOfSalaryForTeacher() {
        return employService.sumOfSalaryForTeacher();
    }

    @GetMapping("/sum-of-salary-for-priest")
    public Double sumOfSalaryForPriest() {
        return employService.sumOfSalaryForPriest();
    }

    @GetMapping("/sum-of-salary-for-janitor")
    public Double sumOfSalaryForJanitor() {
        return employService.sumOfSalaryForJanitor();
    }
}
