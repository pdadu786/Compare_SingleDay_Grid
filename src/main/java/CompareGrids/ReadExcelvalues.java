package CompareGrids;

/**
 * Created by praveendadu on 15/07/2017.
 */
import jdk.nashorn.internal.runtime.NumberToString;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;


/**
 * Created by praveendadu on 6/2/17.
 */
public class ReadExcelvalues {
    static String Namenaverage = "";
    static String fileName = "//Users//praveendadu//Documents//QA//Test_Data.xlsx";
    static  InputStream XlsxFileToRead = null;
    static XSSFWorkbook workbook = null;
    static  XSSFRow row;
    static XSSFCell cell;
    public static Iterator returnString() {
        try {
            XlsxFileToRead = new FileInputStream(fileName);
            //Getting the workbook instance for xlsx file
            workbook = new XSSFWorkbook(XlsxFileToRead);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        //getting the first sheet from the workbook using sheet name.
        // We can also pass the index of the sheet which starts from '0'.
        XSSFSheet sheet = workbook.getSheet("Sheet1");
       // System.out.println(sheet.getLastRowNum());
        //Iterating all the rows in the sheet
        Iterator rows = sheet.rowIterator();
        return rows;
    }
    public static String returnvalues(String valueType) {
       Iterator rows  = returnString();
      while (rows.hasNext()) {
            row = (XSSFRow) rows.next();
            //Iterating all the cells of the current row
            Iterator cells = row.cellIterator();
            while (cells.hasNext()) {
                    cell = (XSSFCell) cells.next();
                   if((cell.getRowIndex() !=0)) {
                       if (valueType.equals("programnamenAverage")) {
                           if (cell.getColumnIndex() == 0 || cell.getColumnIndex() == 1 || cell.getColumnIndex() == 2 || cell.getColumnIndex() == 3) {
                               if (cell.getCellTypeEnum() == CellType.STRING) {
                                   if (cell.getRowIndex() == 1) {
                                       Namenaverage = cell.getStringCellValue();
                                   } else {
                                       Namenaverage = Namenaverage + ", " + cell.getStringCellValue();
                                   }
                               } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                                   Namenaverage = Namenaverage + ", " + Double.toString(cell.getNumericCellValue());
                               } else if (cell.getCellTypeEnum() == CellType.BLANK) {
                               }
                           }
                       }
                       else if(valueType.equals("Data")) {
                           if (cell.getColumnIndex() == 4 || cell.getColumnIndex() == 5 || cell.getColumnIndex() == 6) {
                               if (cell.getCellTypeEnum() == CellType.STRING) {
                                   if (cell.getRowIndex() == 1) {
                                       Namenaverage = cell.getStringCellValue();
                                   } else {
                                       Namenaverage = Namenaverage + ", " + cell.getStringCellValue();
                                   }
                               } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                                   if (cell.getRowIndex() == 1 && cell.getColumnIndex() == 4) {
                                       Namenaverage = Double.toString(cell.getNumericCellValue());
                                   } else {
                                       Namenaverage = Namenaverage + ", " + Double.toString(cell.getNumericCellValue());
                                   }
                               } else if (cell.getCellTypeEnum() == CellType.BLANK) {
                               }
                           }
                       }
                       else if(valueType.equals("Hut")) {
                           if (cell.getColumnIndex() == 7) {
                               if (cell.getCellTypeEnum() == CellType.STRING) {
                                   if (cell.getRowIndex() == 1) {
                                       Namenaverage = cell.getStringCellValue();
                                   } else {
                                       Namenaverage = Namenaverage + ", " + cell.getStringCellValue();
                                   }
                               } else if (cell.getCellTypeEnum() == CellType.NUMERIC) {
                                   if (cell.getRowIndex() == 1) {
                                       Namenaverage = Double.toString(cell.getNumericCellValue());
                                   } else {
                                       Namenaverage = Namenaverage + ", " + Double.toString(cell.getNumericCellValue());
                                   }
                               } else if (cell.getCellTypeEnum() == CellType.BLANK) {
                               }
                           }
                       }

                }
            }
            try {
                XlsxFileToRead.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return Namenaverage;
    }
}