package LoginProcess;

import org.testng.annotations.Test;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
//import org.openqa.selenium.edge.EdgeDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;


public class ValidLoginTestCases {
	
	WebDriver driver = new ChromeDriver () ;
//	WebDriver driver2 = new EdgeDriver () ;
//	WebDriver driver3 = new FirefoxDriver () ;
	String MyURL = "https://www.saucedemo.com/" ;
	String UserName = "standard_user" ;
	String Password = "secret_sauce" ;
	
	@BeforeTest
	public void Setup () {
//		driver2.get("https://www.google.com");
//		driver3.get("https://www.google.com");
		driver.manage().window().maximize();
		driver.get(MyURL);
	}
	
	@Test(priority = 1)
	public void LoginTestUsingStandardUsers () {
//		driver.findElement(By.cssSelector("#user-name")).sendKeys("standard_user");
		WebElement UserNameInput = driver.findElement(By.id("user-name"));
		WebElement PasswordInput = driver.findElement(By.id("password"));
		WebElement LoginButton = driver.findElement(By.id("login-button"));
		
		UserNameInput.sendKeys(UserName);
		PasswordInput.sendKeys(Password);
		LoginButton.click();
	}
	
	@Test(priority = 2)
	public void AddToCart () {
		WebElement FirstAddToCartButton = driver.findElement(By.id("add-to-cart-sauce-labs-backpack"));
		
//		FirstAddToCartButton.click();
	}
	
	@Test(priority = 3)
	public void PrintTheNamesOfTheItems() {
	    String ItemName = driver.findElement(By.className("inventory_item_name")).getText();
	    System.out.println(ItemName);

	    List<WebElement> AddToCartButton = driver.findElements(By.className("btn"));
	    List<WebElement> ItemsNames = driver.findElements(By.className("inventory_item_name"));
	    List<WebElement> ItemsPrices = driver.findElements(By.className("inventory_item_price"));

	    for (int i = 0; i < AddToCartButton.size(); i++) {
	        String PriceAfterTax = ItemsPrices.get(i).getText().replace("$", " ");
	        double PriceAsDouble = Double.parseDouble(PriceAfterTax);
	        double TaxValue = 0.1;
	        double FinalPrice = PriceAsDouble * TaxValue + PriceAsDouble;

	        int FirstDigitAfterDecimal = getFirstDigitAfterDecimal(FinalPrice);
	        System.out.println(FirstDigitAfterDecimal);

	        String msg;
	        if (FirstDigitAfterDecimal % 2 == 0) {
	            msg = "The final price is an even number";
	        } else {
	            msg = "The final price is an odd number";
	        }

	        if (ItemsNames.get(i).getText().contains("Backpack") || ItemsNames.get(i).getText().contains("Fleece") || ItemsNames.get(i).getText().contains("Onesie")) {
	            System.out.println("This Item " + ItemsNames.get(i).getText() + " Skipped" + " ,and the original price of this item is " + ItemsPrices.get(i).getText() + " ,and the price after tax is " + FinalPrice + msg);
	            continue;
	        } else {
	            AddToCartButton.get(i).click();
	            System.out.println("This Item " + ItemsNames.get(i).getText() + " Added" + " ,and the original price of this item is " + ItemsPrices.get(i).getText() + " ,and the price after tax is " + FinalPrice + msg);
	        }
	    }
	}

	private int getFirstDigitAfterDecimal(double finalPrice) {
	    // Extract the integer part of the number
	    int integerPart = (int) finalPrice;

	    // Extract the digit after the decimal point
	    int firstDigit = Character.getNumericValue(Integer.toString((int) ((finalPrice - integerPart) * 10)).charAt(0));

	    return firstDigit;
	}


	@AfterTest
	public void PostTesting () {}
	
}
