package co.test.selenium.demo;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Demo {
	
	WebDriver driver;
	
	// Basic functions
	void initializeDriver() {
		// need to type a command so that drivers are connected to our program
		System.setProperty("webdriver.chrome.driver", "C:\\Users\\ndas\\Desktop\\drivers\\chromedriver_win32\\chromedriver.exe");
		// Setup a new driver WebDriver 
		driver = new ChromeDriver();
	}
	
	boolean getWebsite(String website, String confirmation) {
		// Access website using driver.get
		driver.get(website);
		//System.out.println(driver.getPageSource());
		boolean result = driver.getPageSource().contains(confirmation);
		return result;
	}
	
	void maximizeWindow() {
		// maximize the window
		driver.manage().window().maximize();
		//return driver.findElement(By.cssSelector("input[type='button']"));
	}
	
	void inputKeys(String elementid, String input) {
		// find your input box and send it some keys
		driver.findElement(By.id(elementid)).sendKeys(input);
	}
	
	void clickButton(String classId) {
		// clickButton provided by id
		driver.findElement(By.xpath(classId)).click();
	}
	
	void closeDriver() {
		// Close the window
		driver.close();
	}
	
	String getTitle() {
		return driver.getTitle();
	}
	
	// Test cases
	void NavlinkTestCase1() throws InterruptedException {
		this.initializeDriver();

		// Get Test
		boolean res = this.getWebsite("https://www.opentext.com", "Empowering the Intelligent and Connected Enterprise");
		assert res == true;
		
		// Maximize window
		this.maximizeWindow();
		
		// Click a navlink item
		this.clickButton("//*[@id='site-menu-list']/li[1]/a");
		Thread.sleep(1000);
		this.clickButton("//*[@id=\"site-menu-list\"]/li[1]/ul/li[2]");
		
		Thread.sleep(2000);
		// Access new page and close driver
		this.closeDriver();
	}
	
	void NavlinkTestCase2() throws InterruptedException {
		this.initializeDriver();

		// Get Test
		boolean res = this.getWebsite("https://www.opentext.com", "Empowering the Intelligent and Connected Enterprise");
		assert res == true;
		
		// Maximize window
		this.maximizeWindow();
		
		// Click a search button
		this.clickButton("/html/body/div[2]/nav[2]/ul/li[4]/a");
		Thread.sleep(1000);
		
		// Enter some input
		this.inputKeys("search", "technical support");
		this.clickButton("//*[@id=\"main\"]/div[1]/div/div/div/form/div/div[2]/button");
		
		Thread.sleep(2000);
		// Access new page and close driver
		this.closeDriver();
	}
	

	public static void main(String[] args) throws InterruptedException {
			Demo d = new Demo();
			//d.NavlinkTestCase1();
			d.NavlinkTestCase2();
	}	

}
