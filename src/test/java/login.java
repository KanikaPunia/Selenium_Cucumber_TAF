

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import ExtentReport.ExtentReport;
import PageFactory.HomePage;
import PageFactory.Login;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class login {
	  WebDriver driver;

	    Login objLogin;

	    HomePage objHomePage;
	
	    ExtentReport extRpt = new ExtentReport();

	@Given("^I'm in the guru bank login page$")
	public void i_m_in_the_guru_bank_login_page() throws Throwable {
		 // Write code here that turns the phrase above into concrete actions
			System.setProperty("webdriver.chrome.driver","C:\\ChromeDriver\\chromedriver.exe");
			
			    driver = new ChromeDriver();

		        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

		        driver.get("http://demo.guru99.com/V4/");
		     
		        extRpt.setUpReport();
	
	}

	@When("^I enter \"([^\"]*)\" and \"([^\"]*)\"$")
	public void i_enter_and(String userName, String password) throws Throwable {
extRpt.startTestCase("User Login");
		
	    objLogin = new Login(driver);

	    //Verify login page title

	   
	    
	    String loginPageTitle = objLogin.getLoginTitle();

	  
	    //login to application

	    objLogin.loginToGuru99(userName, password);
	   
	    extRpt.logEvents("Logged Successfully");
	  
	   
	}

	@Then("^I should able to navigate to the home page$")
	public void i_should_able_to_navigate_to_the_home_page() throws Throwable {
		 objHomePage = new HomePage(driver);

		    //Verify home page

		 objHomePage = new HomePage(driver);

		    //Verify home page

		    Assert.assertTrue(objHomePage.getHomePageDashboardUserName().toLowerCase().contains("manger id : mgr123"));
		    driver.close();
		   
		    extRpt.createFinalReport();
		 
	}


}
