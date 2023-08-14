import com.unoveo.calculatorUtils.CalculatorModel;
import org.junit.jupiter.api.Test;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
    private final String TEST_CASES_FILE = "src/test/java/Calculator-Test.xlsx";
    private final String SHEET_NAME = "Sheet1";

    @Test
    public void runCalculatorTestCases() {
        try {
            FileInputStream fis = new FileInputStream(TEST_CASES_FILE);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet(SHEET_NAME);

            for (Row row : sheet) {
                if (row.getRowNum() == 0) // Skip the header row
                    continue;

                Cell testCaseIdCell = row.getCell(0);
                Cell input1Cell = row.getCell(1);
                Cell input2Cell = row.getCell(2);
                Cell operatorCell = row.getCell(3);
                Cell expectedResultCell = row.getCell(4);

                int testCaseId = (int) testCaseIdCell.getNumericCellValue();
                double input1 = input1Cell.getNumericCellValue();
                double input2 = input2Cell.getNumericCellValue();
                String operator = operatorCell.getStringCellValue();
                double expectedResult = expectedResultCell.getNumericCellValue();
                System.out.println("this is expected result"+expectedResult);

                // Perform the calculator operation and assert the result
                CalculatorModel calculatorModel = new CalculatorModel();
                float actualResult = CalculatorModel.operations((float) input1, operator, (float) input2);
                System.out.println("this is actual result"+actualResult);
                assertEquals(expectedResult, actualResult, 0.01, "Test Case ID: " + testCaseId);
            }

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testJSon (){

        try {
            FileInputStream fis = new FileInputStream(TEST_CASES_FILE);
            Workbook workbook = new XSSFWorkbook(fis);
            Sheet sheet = workbook.getSheet("Sheet2");

            for (Row row : sheet) {
                if (row.getRowNum() == 0) // Skip the header row
                    continue;

                Cell testCaseIdCell = row.getCell(0);
                Cell inputCell = row.getCell(1);
                Cell expectedResultCell = row.getCell(2);
                int testCaseId = (int) testCaseIdCell.getNumericCellValue();
                String input = (inputCell.getStringCellValue());
                double expectedResult = expectedResultCell.getNumericCellValue();
                System.out.println("this is expected result"+expectedResult);
                // Perform the calculator operation and assert the result
                float actualResult = CalculatorModel.calculation( input);
                System.out.println("this is actual result"+actualResult);
                assertEquals(expectedResult, actualResult, 0.01, "Test Case ID: " + testCaseId);
            }

            workbook.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }








     //   CalculatorDTO cd = new CalculatorDTO();
     //    String jsonString = "[{type:\"NUMBER\",value:12}"+ "{type:\"OPERATOR\",value:ADD}"+ "{type:\"NUMBER\",value:12}]";
      // String test = (String.valueOf(CalculatorModel.calculation(jsonString)));

    }

}