package TestCases;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class foreksnewsStep {
    WebDriver driver;
    String url = "http://webcli-test.foreks.com.s3-website.eu-central-1.amazonaws.com/foreks/#!/";
    String username = "fatihgumussoy";
    String password = "123456";

    public void setup(String url) {
        System.setProperty("webdriver.chrome.driver", "/Users/aysenurkaya/Downloads/chromedriver");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
    }
    @Given("go to foreks page")
    public void go_to_foreks_page() {
        setup(url);
    }

    @Given("write username")
    public void write_username() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@frks-id='loginUserName']")));
        driver.findElement(By.xpath("//*[@frks-id='loginUserName']")).sendKeys(username);

    }


    @Given("write password")
    public void write_password() {

        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@frks-id='loginPassword']")));
        driver.findElement(By.xpath("//*[@frks-id='loginPassword']")).sendKeys(password);

    }

    @When("click login button")
    public void click_login_button() throws InterruptedException {
        driver.findElement(By.xpath("//*[@frks-id='home-login-btn']")).click();
        Thread.sleep(2000);
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class,'ok')]")));
        driver.findElement(By.xpath("//button[contains(@class,'ok')]")).click();

    }

    @Then("check the success message")
    public void check_the_success_message() {

        String cikis = driver.findElement(By.xpath("//li[@frks-id='mainExitBtn']")).getText();
        System.out.println(cikis);
    }
    @Given("open modul list page")
    public void open_modul_list_page() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@id='widget-menu-header-button']")));
        driver.findElement(By.xpath("//div[@id='widget-menu-header-button']")).click();
    }



    @Given("click news widget")
    public void click_news_widget() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Gündem & Haberler')]")));
        driver.findElement(By.xpath("//div[contains(text(),'Gündem & Haberler')]")).click();
        Thread.sleep(2000);
    }


    @When("open the widget")
    public void open_the_widget() {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Toplu Haber')]")));
        driver.findElement(By.xpath("//div[contains(text(),'Toplu Haber')]")).click();
        String news =driver.findElement(By.xpath("//span[@class='ui-dialog-title']")).getText();
        System.out.println(news);
    }


    @Then("read the news")
    public void read_the_news() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, 30);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Tüm Haberler')]")));
        driver.findElement(By.xpath("//div[contains(text(),'Tüm Haberler')]")).click();
        String title=driver.findElement(By.xpath("//div[text()='Başlık']")).getText();
        System.out.println(title);
        Thread.sleep(2000);
        System.out.println("Foreks haberler  cucumber senaryo başarılı şekilde gerçekleşti");
        driver.quit();
    }

}
