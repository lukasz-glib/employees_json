package pl.lg.employeesjson.employees.domain.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import pl.lg.employeesjson.employees.domain.entities.Employee;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    @Query(value = "SELECT SUM(salary) FROM employee WHERE job='Teacher';", nativeQuery = true)
    Double sumOfSalaryForTeacher();

    @Query(value = "SELECT SUM(salary) FROM employee WHERE job='Priest';", nativeQuery = true)
    Double sumOfSalaryForPriest();

    @Query(value = "SELECT SUM(salary) FROM employee WHERE job='Janitor';", nativeQuery = true)
    Double sumOfSalaryForJanitor();
}
