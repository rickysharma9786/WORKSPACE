package stepdefinition;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.junit.Assert;

public class LoginTest 
	{
	 public WebDriver driver;
	 
	    @Given("^Open Chrome browser and launch the application$")
	    public void open_linkedin_application() 
	    	{
	    		System.setProperty("webdriver.chrome.driver","C:\\MyTestingWork\\MyWorkspace\\JAVA\\eclipse\\DRIVERS\\CHROME73\\chromedriver.exe");
	    		driver = new ChromeDriver();
	    		 		
	    		driver.manage().window().maximize();
				driver.manage().deleteAllCookies();
				driver.manage().timeouts().pageLoadTimeout(40, TimeUnit.SECONDS);
				driver.manage().timeouts().implicitlyWait(30,TimeUnit.SECONDS);
				
	    		driver.get("https://www.linkedin.com/");
	    	}
	    
	    @When("^User click on the SignIn Button$")
	    public void user_click_signin_button()
	    	{
	    		driver.findElement(By.className("nav__button-secondary")).click();
	    		
	    		
	    	}
	 
	    @When("^User enters the username and password onto the UserName and password field$")
	    public void user_enters_username_and_Password() 
	    	{
	    		driver.findElement(By.id("username")).sendKeys("gaurav.ricky.sharma@gmail.com"); 
	    		driver.findElement(By.id("password")).sendKeys("Gaurav@9786"); 
	    		
	    	}
	    
	    @When("^User clicks on the Login button$")
	    public void user_click_login_button()
	    	{
	    		driver.findElement(By.className("login__form_action_container")).click();
	    		
	    	}
	    
	    @Then("^Validate if the user login is successful$") 
	    public void validate__Homepage() 
	    	{
	    	String url = driver.getCurrentUrl();
			System.out.println(url);
			Assert.assertEquals(url, "https://www.linkedin.com/feed/?trk=guest_homepage-basic_nav-header-signin");
	    	}
	    
	    @Then("^Close the browser$") 
	    public void browser_tear_down() 
	    	{
	    		driver.findElement(By.id("nav-settings__dropdown")).click();
	    		driver.findElement(By.xpath("//a[starts-with(@id,'ember')]")).click();
	    		driver.close();
	    	}

}
