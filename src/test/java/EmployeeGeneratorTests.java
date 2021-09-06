import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Random;

public class EmployeeGeneratorTests {
    private static Employee randomEmployee;
    private static Map<String, Employee> employeesMap;

    @BeforeAll
    public static void setup(){
        //returning employees map
        employeesMap = new EmployeesGenerator().generateEmployeesMap();
        //returning our employees raw data as a string
        List<String[]> employeeRawData = new EmployeeRecordScanner().generateRawEmployeeData();
        //instantiating the random to generate random for us
        Random random = new Random();
        //utilising random by passing our raw data array as a size to generate our number within the bounds of information
        //then adding it as an employee object
        randomEmployee = new Employee(employeeRawData.get(random.nextInt(employeeRawData.size())));
    }

    @Test
    public void employeeGeneratorTests(){
        assertEquals(randomEmployee.getFirstName(), employeesMap.get(randomEmployee.getEmployeeID()).getFirstName());
    }

}
