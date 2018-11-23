import java.io.FileInputStream;
import java.io.IOException;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelRead {

	public static void main(String[] args) throws IOException  {
		// finds execl file 
		FileInputStream fil = new FileInputStream ("C:\\Users\\Reverside\\Desktop\\QA Assesment\\Testdata.xlsx");
// retrieves information from workbook 
		XSSFWorkbook wb = new XSSFWorkbook(fil);
		XSSFSheet sheet = wb.getSheet("Test Data");
		/// Iterator rows and cells 
		Iterator<Row> rowIt=sheet.iterator();
		rowIt.next();
		while(rowIt.hasNext()) {
			System.out.println(rowIt.next().getCell(0).getStringCellValue());
		}
		
	}


}
