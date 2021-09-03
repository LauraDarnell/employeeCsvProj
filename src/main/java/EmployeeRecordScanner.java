import configManager.ConfigManager;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class EmployeeRecordScanner {
    // variable below is simply our file reading object
    private final EmployeeFileReader employeeFileReader = new EmployeeFileReader();


    public List<String[]> generateRawEmployeeData() {
        List<String[]> employeeRawData = new ArrayList<>();

        //scanner below takes our file reader object and prepares a scanner object to work on our file
        Scanner scanner = new Scanner(employeeFileReader.empFileReader(ConfigManager.employeeFileLocation()));
        //removes headers
        scanner.nextLine();
        while (scanner.hasNext()) {
            //removed print and now looping and adding each item into our raw data array list
            employeeRawData.add(scanner.nextLine().split(","));
        }
        return employeeRawData;
    }

    public static void main(String[] args) {
        EmployeeRecordScanner employeeRecordScanner = new EmployeeRecordScanner();
        //foreach below
        for (String[] anEmployee: employeeRecordScanner.generateRawEmployeeData()) {
            System.out.println(Arrays.toString(anEmployee));
        }


        }
    }

