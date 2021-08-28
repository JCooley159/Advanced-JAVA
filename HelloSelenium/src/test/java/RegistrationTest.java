import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.util.concurrent.TimeUnit;

public class RegistrationTest {

    private static WebDriver driver;

    @BeforeClass
    public static void setUpSelenium()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JCool\\Downloads\\chromedriver_win32y\\chromedriver.exe");
        driver = new ChromeDriver();
    }

    @Test
    public void registrationTest() {
        driver.get("https://ihgrewardsclubdining.rewardsnetwork.com/join.htm");
        WebElement firstName =
                driver.findElement(By.xpath("//*[@id=\"firstName\"]"));
        firstName.click();
        firstName.clear();
        firstName.sendKeys("Jeremy");


        WebElement lastName = driver.findElement(By.xpath("//*[@id=\"lastName\"]"));
        lastName.click();
        lastName.clear();
        lastName.sendKeys("Cooley");


        WebElement zip = driver.findElement(By.xpath("//*[@id=\"zipcode\"]"));
        zip.click();
        zip.clear();
        zip.sendKeys("30044");


        WebElement email = driver.findElement(By.xpath("//*[@id=\"email\"]"));
        email.click();
        email.clear();
        email.sendKeys("jcooley159@gmail.com");


        WebElement emailConfirm = driver.findElement(By.xpath("//*[@id=\"emailConfirm\"]"));
        emailConfirm.click();
        emailConfirm.clear();
        emailConfirm.sendKeys("jcooley159@gmail.com");


        WebElement nextButton = driver.findElement(By.xpath("//*[@id=\"enrollment\"]/div/div[3]/input"));
        nextButton.click();


        WebElement address1 = driver.findElement(By.xpath("//*[@id=\"address1\"]"));
        Assert.assertNotNull(address1);

    }

}
