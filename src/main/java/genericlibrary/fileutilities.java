package genericlibrary;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.math3.analysis.function.Constant;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.Reporter;
import org.testng.annotations.DataProvider;

import com.mysql.cj.exceptions.StatementIsClosedException;
import com.mysql.cj.jdbc.Driver;





/**
 * 
 * @author Adarsh
 *
 */
public class fileutilities  {
	public static Connection con;
/**
 * it is used to read the data from proprty file
 * @param key
 * @return
 * @throws FileNotFoundException
 * @throws IOException
 */
	public String getpropertyfile(String key) throws FileNotFoundException, IOException {
		Properties p=new Properties();
		p.load(new FileInputStream(Autoconstant.datapropertyfile));
		return p. getProperty(key);
		
	}
//	@DataProvider
//	
//	public Object[][] readdatafromexel() throws EncryptedDocumentException, IOException {
//		FileInputStream fis=new FileInputStream(Autoconstant.exelsheetpath);
//		Workbook wb = WorkbookFactory.create(fis);
//		Sheet sh = wb.getSheet("sheet1");
//		 int row = sh.getLastRowNum();
//		 short collemn = sh.getRow(1).getLastCellNum();
//		 
//		 Object obj[][]=new Object[row][collemn];
//		 for(int i=0;i<row;i++) {
//			 for(int j=0;j<collemn;j++) {
//				 sh.getRow(i+1).getCell(j).getStringCellValue();
//				 System.out.println(obj[i][j]);
//				 
//			 }
//		 }
//		return obj;
//	}
	/**
	 * it is used to extract data from exel sheet
	 * @param sheet
	 * @param row
	 * @param cell
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public String getdatafromexelsheet(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		FileInputStream fis=new FileInputStream(Autoconstant.exelsheetpath);
		Workbook wb = WorkbookFactory.create(fis);
		return wb.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
		
	}
	/**
	 * it is used to get data from data base
	 * @return
	 * @throws SQLException
	 */
	public static Connection getdataDB() throws SQLException {
		Driver d=new Driver();
		DriverManager.registerDriver(d);
		return con=DriverManager.getConnection("Jdbc:mysql://localhost:3306/testing","root","Adarshns123$");
		
		
	}
	/**
	 * it is used to exicute query from database
	 * @param query
	 * @param column
	 * @param expdata
	 * @return
	 * @throws SQLException
	 */
	public static String executequery(String query, int column, String expdata) throws SQLException {
		Statement statement = con.createStatement();
		ResultSet result = statement.executeQuery(query);
		while(result.next()) {
			if(result.getString(column).equals(expdata)) {
				Reporter.log("data not matching");
			}
		}
		return expdata;
		
	}
	public void closeDB() throws SQLException {
		// TODO Auto-generated method stub
		con.close();
	}
	
}
