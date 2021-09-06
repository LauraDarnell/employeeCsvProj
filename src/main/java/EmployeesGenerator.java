import java.util.HashMap;
import java.util.Map;

public class EmployeesGenerator {
    private final EmployeeRecordScanner employeeRecordScanner = new EmployeeRecordScanner();

    public Map<String, Employee> generateEmployeesMap() {
        Map<String, Employee> employeesMap = new HashMap<>();

        for (String[] employee : employeeRecordScanner.generateRawEmployeeData()) {
            Employee rawEmployee = new Employee(employee);
            employeesMap.put(rawEmployee.getEmployeeID(), rawEmployee);
        }
        return employeesMap;
    }

}
