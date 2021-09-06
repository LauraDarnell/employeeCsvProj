import configManager.ConfigManager;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeRecordScanner {
    private static final Logger logger = LogManager.getLogger(EmployeeRecordScanner.class);
    // variable below is simply our file reading object
    private final EmployeeFileReader employeeFileReader = new EmployeeFileReader();


    public List<String[]> generateRawEmployeeData() {
        List<String[]> employeeRawData = new ArrayList<>();

        //scanner below takes our file reader object and prepares a scanner object to work on our file
        logger.debug("Start employees CSV scanner");
        Scanner scanner = new Scanner(employeeFileReader.empFileReader(ConfigManager.employeeFileLocation()));
        //removes headers
        scanner.nextLine();
        while (scanner.hasNext()) {
            //removed print and now looping and adding each item into our raw data array list
            employeeRawData.add(scanner.nextLine().split(","));
        }
        logger.debug("Employees scanner finished");
        return employeeRawData;
    }

    public static void main(String[] args) {
        EmployeeRecordScanner employeeRecordScanner = new EmployeeRecordScanner();
        employeeRecordScanner.generateRawEmployeeData();
    }

    }

