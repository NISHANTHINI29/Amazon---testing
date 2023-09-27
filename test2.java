package sampletest;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class test2 {
    private WebDriver driver;
   
    @BeforeTest
    public void setUp() {
        // Set the path to your Chrome WebDriver executable
        System.setProperty("webdriver.chrome.driver", "C:/Users/Vaishnavi/Downloads/chromedriver-win32/chromedriver-win32/chromedriver.exe");

        // Initialize the WebDriver
        driver = new ChromeDriver();
        

        // Maximize the browser window (optional)
        driver.manage().window().maximize();
    }

    @Test(priority = 1)
    public void loginToAmazon() {
    	
        // Step 1: Login to Amazon (Assuming you are already authenticated)
        
    	 driver.get("https://www.amazon.in");
    	 driver.findElement(By.linkText("Sign in")).click();
         //Step 2: Find the mailid input field and enter your mail
    	 WebElement emailInput = driver.findElement(By.id("ap_email"));
         emailInput.sendKeys("nishanthini580@gmail.com"); // Replace with your email
         
         driver.findElement(By.xpath("//*[@id=\"continue\"]")).click();
         // Step 3: Find the password input field and enter your password
         WebElement passwordInput = driver.findElement(By.id("ap_password"));
         passwordInput.sendKeys("Nisha580"); // Replace with your password
         
         // Step 4: Find the login button and click it
         WebElement loginButton = driver.findElement(By.id("signInSubmit"));
         loginButton.click();
    }

    @Test(priority = 2)
    public void searchForProduct() {
    	
        // Step 5: Search for a product
    	
        WebElement searchInput = driver.findElement(By.id("twotabsearchtextbox"));
        searchInput.sendKeys("watch");
        driver.findElement(By.id("nav-search-submit-button")).click();
    }

    @Test(priority = 3)
    public void chooseProduct() {
    	
    	 // Step 5: tick in check box of top-brand in fastrack
	    driver.findElement(By.xpath("//*[@id=\"p_89/Fastrack\"]/span/a/div")).click();
	    
        // Step 6: from drop down select Newest Arriavals
	    Select se = new Select(driver.findElement(By.xpath("//*[@id=\"s-result-sort-select\"]")));
        se.selectByIndex(4);
		
    }

    @Test(priority = 4)
    public void addtocart() {
        // Step 7: Proceed to the payment process (Simulated click on "Add to Cart")
    	//driver.findElement(By.linkText("Analog White Dial Men's Casual Watch")).click();
    	driver.get("https://www.amazon.in/Fastrack-Analog-White-Casual-Watch/dp/B0CFFVF923/ref=sr_1_1?keywords=watch&qid=1695636478&refinements=p_89%3AFastrack&rnid=3837712031&s=watches&sr=1-1");
    	Actions actions = new Actions(driver);//action for movement
    	
    	
    	WebElement blog3 =driver.findElement(By.xpath("//*[@id=\"a-autoid-4\"]"));
    	actions.moveToElement(blog3).perform();
    	
    	WebElement blog4 =driver.findElement(By.xpath("//*[@id=\"a-autoid-5\"]"));
    	actions.moveToElement(blog4).perform();
    	
    	WebElement blog5 =driver.findElement(By.xpath("//*[@id=\"a-autoid-6\"]"));
    	actions.moveToElement(blog5).perform();
    	
    	driver.findElement(By.id("add-to-cart-button")).click();
       
       }
    
    @Test(priority = 5)
    public void proceedToCheckout() {
        // Step 8: Find the "Proceed to Checkout" button and click it
        WebElement proceedToCheckoutButton = driver.findElement(By.linkText("Go to Cart"));
        proceedToCheckoutButton.click();
    
        
        // Filling out shipping and payment information, as needed.
    
    }
    @AfterTest
    public void tearDown() {
        //Close the browser
       driver.close();
       System.out.println("watch is add to cart in amazon website");
       System.out.println("Have a nice day!!!");
    }
}
