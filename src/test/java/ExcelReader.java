//import java.io.File;
//import java.io.IOException;
//import java.util.ArrayList;
//import java.util.stream.Stream;
//import org.apache.poi.ss.usermodel.Cell;
//import org.apache.poi.ss.usermodel.DataFormatter;
//import org.apache.poi.ss.usermodel.Row;
//import org.apache.poi.ss.usermodel.Sheet;
//import org.apache.poi.ss.usermodel.Workbook;
//import org.apache.poi.ss.usermodel.WorkbookFactory;
//import org.junit.jupiter.params.provider.Arguments;
//
//public class ExcelReader {
//
//
//    public static void main(String[] args) {
//        getTestDataStreamFromExcelFile("C:\\Projects\\reactapps\\react-calculator\\react-calculator-backend\\src\\test\\java\\Calculator-Test.xlsx",
//                "Sheet1");
//
//    }
//
//    static Stream<Arguments> testValues1() {
//        return getTestDataStreamFromExcelFile("C:\\Projects\\reactapps\\react-calculator\\react-calculator-backend\\src\\test\\java\\Calculator-Test.xlsx",
//                "Sheet1");
//    }
//    public static Stream<Arguments> getTestDataStreamFromExcelFile(String excelFullPath,
//                                                                   String sheetName){
//        Stream<Arguments> returnStream = Stream.empty();
//        DataFormatter myDataFormatter = new DataFormatter();
//
//        try(Workbook excelFile = WorkbookFactory.create(new File(excelFullPath),null,true)) {
//            Sheet excelSheet1 = excelFile.getSheet(sheetName);
//
//            for(Row row: excelSheet1){
//                if(row.getRowNum()==0) {continue;}
//                ArrayList<Object> rowArrayList = new ArrayList<>();
//                for (Cell cell : row) {
//                    rowArrayList.add(myDataFormatter.formatCellValue(cell));
//                }
//                Arguments arguments = Arguments.of(rowArrayList.toArray());
//                returnStream = Stream.concat(returnStream,Stream.of(arguments));
//            }
//            return returnStream;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return returnStream;
//    }
//    static String[][] testValues2() {
//        return getTestData2dArrayFromExcelFile("C:\\Projects\\reactapps\\react-calculator\\react-calculator-backend\\src\\test\\java\\Calculator-Test.xlsx",
//                "Sheet1");
//    }
//
//    public static String[][] getTestData2dArrayFromExcelFile(String excelFullPath, String sheetName){
//        DataFormatter myDataFormatter = new DataFormatter();
//
//        try(Workbook excelFile = WorkbookFactory.create(
//                new File(excelFullPath),null,true)) {
//
//            Sheet excelSheet1 = excelFile.getSheet(sheetName);
//            int firstRow = excelSheet1.getFirstRowNum();
//            int lastRow = excelSheet1.getLastRowNum();
//            String[][] testData2dArray = new String[lastRow][];
//
//            //skipping the title row in the sheet
//            for (int i = firstRow+1; i <= lastRow; i++) {
//                Row row = excelSheet1.getRow(i);
//                int firstCellNum = row.getFirstCellNum();
//                int lastCellNum = row.getLastCellNum();
//                String[] testDataArray = new String[lastCellNum];
//
//                for (int j = firstCellNum; j < lastCellNum; j++) {
//                    testDataArray[j]=myDataFormatter.formatCellValue(row.getCell(j));
//                }
//                testData2dArray[i-1]=testDataArray;
//            }
//            return testData2dArray;
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//
//
//
//}