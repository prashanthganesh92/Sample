package org.packag.dataProviders;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class baseClass {

	WebDriver driver;

	public void browserLaunch(String url) {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.get(url);

	}

	public WebElement elementLocator(String LocatorType, String value) {
		if (LocatorType.equals("id")) {
			WebElement userName = driver.findElement(By.id(value));
			return userName;
		} else if (LocatorType.equals("name")) {
			WebElement nameField = driver.findElement(By.name(value));
			return nameField;
		} else {
			WebElement xpath = driver.findElement(By.xpath(value));
			return xpath;
		}
	}

	public void enterText(WebElement element, String text) {
		element.sendKeys(text);
	}

	public String excelRead(String sheetName, int rowNum, int cellNum) throws IOException {
		File f = new File("D:\\Maven Trial\\HotelBooking.xlsx");
		FileInputStream stream = new FileInputStream(f);
		Workbook w = new XSSFWorkbook(stream);
		Sheet sheet = w.getSheet(sheetName);
		Row row = sheet.getRow(rowNum);
		Cell cell = row.getCell(cellNum);
		int cellType = cell.getCellType();
		if (cellType == 1) {
			String stringCellValue = cell.getStringCellValue();
			return stringCellValue;
		} else if (DateUtil.isCellDateFormatted(cell)) {
			Date dateCellValue = cell.getDateCellValue();
			SimpleDateFormat s = new SimpleDateFormat("dd/MM/yyyy");
			String format = s.format(dateCellValue);
			return format;
		} else {
			double numericCellValue = cell.getNumericCellValue();
			long l = (long) numericCellValue;
			String valueOf = String.valueOf(l);
			return valueOf;
		}

	}

	public void excelWrite(String sheetName, int rowNum, int cellNum, String cellValue) throws IOException {
		File f = new File("D:\\Maven Trial\\HotelBooking.xlsx");
		Workbook w = new XSSFWorkbook();
		Sheet createSheet = w.createSheet(sheetName);
		Row createRow = createSheet.createRow(rowNum);
		Cell createCell = createRow.createCell(cellNum);
		createCell.setCellValue(cellValue);
		FileOutputStream stream = new FileOutputStream(f);
		w.write(stream);
	}

	public void mouseOverActions(WebElement element) {
		Actions a = new Actions(driver);
		a.moveToElement(element).perform();
	}

	public void doubleClickAction(WebElement element) {
		Actions a = new Actions(driver);
		a.doubleClick(element).perform();
	}

	public void selectFromDropdown(WebElement element, int value) {
		Select a = new Select(element);
		a.selectByIndex(value);
	}
}
