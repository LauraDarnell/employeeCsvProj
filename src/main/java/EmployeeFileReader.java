import java.io.FileNotFoundException;
import java.io.FileReader;

public class EmployeeFileReader {

    public FileReader empFileReader(String employeeFileLocation){
        try {
            return new FileReader(employeeFileLocation);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
