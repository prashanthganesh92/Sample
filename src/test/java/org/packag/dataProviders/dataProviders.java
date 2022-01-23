package org.packag.dataProviders;

import java.io.IOException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataProviders extends baseClass{
	
	@Test(dataProvider = "sampleData")
	private void dataEntry(String uname, String pass, String fName, String lName, String add, String cc, String cvv) throws InterruptedException, IOException {
		browserLaunch("http://adactinhotelapp.com/");
		Thread.sleep(3000);
		WebElement userName = elementLocator("id", "username");
		enterText(userName, uname);
		WebElement password = elementLocator("id", "password");
		enterText(password, pass);
		WebElement buttonClick = elementLocator("id", "login");
		buttonClick.click();
		WebElement Location = elementLocator("xpath", "//select[@name='location']");
		Location.click();
		selectFromDropdown(Location, 3);
		WebElement hotels = elementLocator("xpath", "//select[@name='hotels']");
		hotels.click();
		selectFromDropdown(hotels, 2);
		WebElement room = elementLocator("xpath", "//select[@id='room_type']");
		room.click();
		selectFromDropdown(room, 3);
		WebElement roomNo = elementLocator("xpath", "//select[@name='room_nos']");
		roomNo.click();
		selectFromDropdown(roomNo, 1);
		WebElement checkIn = elementLocator("xpath", "//input[@name='datepick_in']");
		doubleClickAction(checkIn);
		String checkInDate = excelRead("TicketDetails", 0, 2);
		enterText(checkIn, checkInDate);
		WebElement checkOut = elementLocator("xpath", "//input[@name='datepick_out']");
		doubleClickAction(checkOut);
		String checkOutDate = excelRead("TicketDetails", 0, 3);
		enterText(checkOut, checkOutDate);
		WebElement personRoom = elementLocator("xpath", "//select[@name='adult_room']");
		personRoom.click();
		selectFromDropdown(personRoom, 2);
		WebElement childRoom = elementLocator("xpath", "//select[@name='child_room']");
		childRoom.click();
		selectFromDropdown(childRoom, 2);
		WebElement submitClick = elementLocator("xpath", "//input[@type='submit']");
		submitClick.click();
		WebElement radioButtonClick = elementLocator("xpath", "//input[@id='radiobutton_0']");
		radioButtonClick.click();
		WebElement pageClick = elementLocator("xpath", "//input[@type='submit']");
		pageClick.click();
		WebElement firstName = elementLocator("xpath", "//input[@name='first_name']");
		enterText(firstName, fName);
		WebElement lastName = elementLocator("xpath", "//input[@name='last_name']");
		enterText(lastName, lName);
		WebElement address = elementLocator("xpath", "//textarea[@name='address']");
		enterText(address, add);
		WebElement creditCard = elementLocator("xpath", "//input[@name='cc_num']");
		enterText(creditCard, cc);
		WebElement ccType = elementLocator("xpath", "//select[@name='cc_type']");
		ccType.click();
		selectFromDropdown(ccType, 2);
		WebElement ccExpMonth = elementLocator("xpath", "//select[@name='cc_exp_month']");
		ccExpMonth.click();
		selectFromDropdown(ccExpMonth, 10);
		WebElement ccExpYear = elementLocator("xpath", "//select[@name='cc_exp_year']");
		ccExpYear.click();
		selectFromDropdown(ccExpYear, 12);
		WebElement cvvNumber = elementLocator("xpath", "//input[@name='cc_cvv']");
		enterText(cvvNumber, cvv);
		WebElement bookNowButton = elementLocator("xpath", "//input[@type='button']");
		bookNowButton.click();
	}
	
	@DataProvider(name = "sampleData")
	private Object [][] dataProviding () throws IOException{
		return new Object [][] {
			{excelRead("TicketDetails", 0, 0),excelRead("TicketDetails", 0, 1), excelRead("TicketDetails", 0, 4), excelRead("TicketDetails", 0, 5), excelRead("TicketDetails", 0, 6), excelRead("TicketDetails", 0, 7), excelRead("TicketDetails", 0, 8)},
			{excelRead("TicketDetails", 1, 0),excelRead("TicketDetails", 1, 1), excelRead("TicketDetails", 1, 4), excelRead("TicketDetails", 1, 5), excelRead("TicketDetails", 1, 6), excelRead("TicketDetails", 1, 7), excelRead("TicketDetails", 1, 8)},
			{excelRead("TicketDetails", 2, 0),excelRead("TicketDetails", 2, 1), excelRead("TicketDetails", 2, 4), excelRead("TicketDetails", 2, 5), excelRead("TicketDetails", 2, 6), excelRead("TicketDetails", 2, 7), excelRead("TicketDetails", 2, 8)},
		};
}
}