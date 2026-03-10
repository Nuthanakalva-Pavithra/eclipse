package StepDefinition;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import junit.framework.Assert;
//import org.testng.AssertJUnit;

public class StepClass {
	WebDriver driver;
	@Given("use is navigated to the login page")
	public void use_is_navigated_to_the_login_page() {
	    // Write code here that turns the phrase above into concrete actions
		driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/login?returnUrl=%2F");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//a[normalize-space()='Log in']"));
	    //throw new io.cucumber.java.PendingException();
	}

	@When("user enters valid credentials")
	public void user_enters_valid_credentials() {
	    // Write code here that turns the phrase above into concrete 
		driver.findElement(By.xpath("//input[@id='Email']")).sendKeys("abc@gmail.com");
		driver.findElement(By.xpath("//input[@id='Password']")).sendKeys("abcdef");
		driver.findElement(By.xpath("//button[normalize-space()='Log in']")).click();
	    //throw new io.cucumber.java.PendingException();
	}

	@Then("user should be navigated to home page")
	public void user_should_be_navigated_to_home_page() {
	    // Write code here that turns the phrase above into concrete actions
		WebElement status=driver.findElement(By.xpath("//h2[normalize-space()='Welcome to our store']"));
		String actualText = status.getText();
		Assert.assertEquals("Welcome to our store", actualText);
		driver.quit();
	    //throw new io.cucumber.java.PendingException();
	}
}
