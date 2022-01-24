package TestCases;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class foreksloginOlumsuz {
    WebDriver driver;
    String url = "http://webcli-test.foreks.com.s3-website.eu-central-1.amazonaws.com/foreks/#!/";
    String username = "otomasyonduzey1plus";
    String password = "778899";

    public void setup(String url) {
        System.setProperty("webdriver.chrome.driver", "/Users/aysenurkaya/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }


    @Given("go to foreks login page")
    public void go_to_foreks_login_page() {
        setup(url);

    }

    @Given("write foreks username")
    public void write_foreks_username() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@frks-id='loginUserName']")));
        driver.findElement(By.xpath("//*[@frks-id='loginUserName']")).sendKeys(username);
    }

    @Given("write not true password")
    public void write_not_true_password() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@frks-id='loginPassword']")));
        driver.findElement(By.xpath("//*[@frks-id='loginPassword']")).sendKeys(password);
    }

    @When("click foreks login button")
    public void click_foreks_login_button() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@frks-id='home-login-btn']")));
        driver.findElement(By.xpath("//*[@frks-id='home-login-btn']")).click();

    }

    @Then("check the error message")
    public void check_the_error_message() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alertify-logs top right']")));
        String message = driver.findElement(By.xpath("//div[@class='alertify-logs top right']")).getText();
        System.out.println(message);
        System.out.println("Foreks login olumsuz cucumber senaryo başarılı şekilde gerçekleşti");
        driver.quit();
    }

}
