package pl;

import java.util.Date;
import java.util.Locale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

@Test
public class Main {
	
	protected WebDriver driver;
	String browserType = "chrome";
	public static final String BASIC_URL = "https://sklep.sizeer.com";
	Faker faker = new Faker(new Locale("pl"));
	
	
	public void sizzerShopRegister() {
		
		driver.get(BASIC_URL + "//registration");
		
		String firstName = faker.name().firstName();
		String lastName = faker.name().lastName();
		String generateEmail = "email".concat(String.valueOf(new Date().getTime())).concat("@gmail.com");
		String password = "Pass123qwerty";
		String cellPhone = faker.phoneNumber().cellPhone();
		String genderM = "2"; 
		String dateOfBrith = "19901212";
		
		
		
		if (driver.findElement(By.id("js-cookieInfo_confirm")).isDisplayed())     
		    driver.findElement(By.id("js-cookieInfo_confirm")).click();
		
		driver.findElement(By.id("enp_customer_registration_form_type_address_firstName")).sendKeys(firstName);
		driver.findElement(By.id("enp_customer_registration_form_type_address_lastName")).sendKeys(lastName);
		driver.findElement(By.id("enp_customer_registration_form_type_email")).sendKeys(generateEmail);
		driver.findElement(By.id("enp_customer_registration_form_type_plainPassword_first")).sendKeys(password);
		driver.findElement(By.id("enp_customer_registration_form_type_plainPassword_second")).sendKeys(password);
		driver.findElement(By.id("enp_customer_registration_form_type_mobileNumber")).sendKeys(cellPhone);
		new Select(driver.findElement(By.id("enp_customer_registration_form_type_extension_gender"))).selectByValue(genderM);
		driver.findElement(By.id("enp_customer_registration_form_type_extension_birthDate")).sendKeys(dateOfBrith);
		driver.findElement(By.id("enp_customer_registration_form_type_consentForm_consent_1319_0")).click();
		driver.findElement(By.id("enp_customer_registration_form_type_consentForm_consent_1317_0")).click();
		driver.findElement(By.cssSelector("#sb-site > main > div > section > div > div.b-col_2.g-pb30 > div > form > div:nth-child(11) > div.m-form_btn > input")).click();
		
	}
	
	@BeforeTest
	public void setUp(){
		
		driver = utilities.DriverFactory.open(browserType);
		driver.get(BASIC_URL);
		driver.manage().window().maximize();

	}
		
//	@AfterMethod
//	public void tearDown(){
//		
//		driver.close();
//			
//	}
}
		
	