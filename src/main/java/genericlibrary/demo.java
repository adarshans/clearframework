package genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class demo extends baseclass {
//	public String getpropertyfile(String key) throws FileNotFoundException, IOException {
//		Properties p=new Properties();
//		p.load(new FileInputStream(Autoconstant.datapropertyfile));
//		return p. getProperty(key);
//	}
	@DataProvider
	
	public Object[][] readdatafromexel() throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(Autoconstant.exelsheetpath);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sh = wb.getSheet("sheet1");
		 int row = sh.getLastRowNum();
		 short collemn = sh.getRow(1).getLastCellNum();
		 
		  Object obj[][]=new Object[row][collemn];
		 for(int i=0;i<row;i++) {
			 for(int j=0;j<collemn;j++) {
				obj[i][j] =sh.getRow(i+1).getCell(j).getStringCellValue();
				 System.out.println(obj[i][j]);
				 
			 }
		 }
		return obj;
	}

}
