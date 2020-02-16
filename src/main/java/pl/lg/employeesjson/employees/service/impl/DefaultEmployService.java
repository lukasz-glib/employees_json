package pl.lg.employeesjson.employees.service.impl;

import lombok.extern.slf4j.Slf4j;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.lg.employeesjson.employees.domain.entities.Employee;
import pl.lg.employeesjson.employees.domain.repositories.EmployeeRepository;
import pl.lg.employeesjson.employees.service.EmployService;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

@Service
@Transactional
@Slf4j
public class DefaultEmployService implements EmployService {

    private final EmployeeRepository employeeRepository;

    public DefaultEmployService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Iterable<Employee> list() {
        return employeeRepository.findAll();
    }

    @Override
    public void saveFromJson() {
        JSONParser parser = new JSONParser();
        Employee employee = new Employee();
        try (FileReader fileReader = new FileReader("src/main/resources/employees.json")){
            Object obj = parser.parse(fileReader);
            JSONArray array = new JSONArray();
            array.add(obj);
            for (Object o : array) {
                JSONObject object = (JSONObject) o;
                String idToParse = object.get("id").toString();
                Long id = Long.parseLong(idToParse);
                employee.setId(id);
                String name = object.get("name").toString();
                employee.setName(name);
                String surname = object.get("surname").toString();
                employee.setSurname(surname);
                String job = object.get("job").toString();
                employee.setJob(job);
                String salaryToDouble = object.get("salary").toString();
                Double salary = Double.parseDouble(salaryToDouble);
                employee.setSalary(salary);
                employeeRepository.save(employee);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public Double sumOfSalaryForTeacher() {
        return employeeRepository.sumOfSalaryForTeacher();
    }

    @Override
    public Double sumOfSalaryForPriest() {
        return employeeRepository.sumOfSalaryForPriest();
    }

    @Override
    public Double sumOfSalaryForJanitor() {
        return employeeRepository.sumOfSalaryForJanitor();
    }
}
