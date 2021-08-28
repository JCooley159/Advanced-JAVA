import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class TuitionCalculatorTest
{
    private static WebDriver driver;



    @BeforeClass
    public static void setUpSelenium()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\JCool\\Downloads\\chromedriver_win32y\\chromedriver.exe");
        driver = new ChromeDriver();
    }




    @Test
    public void inStateTest()
    {
        driver.get("https://www.ggc.edu/admissions/tuition-and-financial-aid-calculators/index.html#");

        // In or Out of State?
        WebElement inOrOut = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/article/div/div[2]/form/div[1]/div/div/div[1]/fieldset/div/label[1]"));
        // Credit Hours?  ------ Default is 15
        WebElement hours = driver.findElement(By.xpath("//*[@id=\"creditHOURS\"]"));
        // Living on Campus?
        WebElement onOrOff0 = driver.findElement(By.xpath("//*[@id=\"onoroff0\"]"));


        Actions builder = new Actions(driver);
        Action clicker = builder.click(inOrOut)
                .click(hours)
                .sendKeys(hours, Keys.ARROW_UP)
                .click(hours)
                .click(onOrOff0)
                .build();
        clicker.perform();


        // Total Cost
        WebElement totalPerSemes = driver.findElement(By.xpath("//*[@id=\"totalcost\"]"));
        double totalPerYear = (Double.valueOf(totalPerSemes.getAttribute("value").substring(1)) * 2.0);


        double inStateEstimate = 5634.0;
        Assert.assertEquals("In-state tuition should be $5,634", inStateEstimate, totalPerYear, 50.0);
    }




    @Test
    public void outOfStateTest()
    {
        driver.get("https://www.ggc.edu/admissions/tuition-and-financial-aid-calculators/index.html#");

        // In or Out of State?
        WebElement inOrOut = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/article/div/div[2]/form/div[1]/div/div/div[1]/fieldset/div/label[2]"));
        // Credit Hours?  ------ Default is 15
        WebElement hours = driver.findElement(By.xpath("//*[@id=\"creditHOURS\"]"));
        // Living on Campus?
        WebElement onOrOff0 = driver.findElement(By.xpath("//*[@id=\"onoroff0\"]"));

        Actions builder = new Actions(driver);
        Action clicker = builder.click(inOrOut)
                .click(hours)
                .click(hours)
                .click(onOrOff0)
                .build();
        clicker.perform();



        // Total Cost
        WebElement totalPerSemes = driver.findElement(By.xpath("//*[@id=\"totalcost\"]"));
        double totalPerYear = (Double.valueOf(totalPerSemes.getAttribute("value").substring(1)) * 2.0);


        double outOfStateEstimate = 16348.0;
        Assert.assertEquals("Out-of-state tuition should be $16,348", outOfStateEstimate, totalPerYear, 50.0);
    }


    @Test
    public void cooleyTuitionTest()
    {

        driver.get("https://www.ggc.edu/admissions/tuition-and-financial-aid-calculators/index.html#");

        // In or Out of State?  ------   IN
        WebElement inOrOut = driver.findElement(By.xpath("//*[@id=\"main-content\"]/div/article/div/div[2]/form/div[1]/div/div/div[1]/fieldset/div/label[1]"));
        // Credit Hours  -------------   14 as opposed to 15
        WebElement hours = driver.findElement(By.xpath("//*[@id=\"creditHOURS\"]"));
        // Living on Campus?  -------    NO
        WebElement onOrOff0 = driver.findElement(By.xpath("//*[@id=\"onoroff0\"]"));


        Actions builder = new Actions(driver);
        Action clicker = builder.click(inOrOut)
                .click(hours)
                .sendKeys(hours, Keys.ARROW_DOWN)
                .click(hours)
                .click(onOrOff0)
                .build();
        clicker.perform();



        // Total Cost
        WebElement totalPerSemes = driver.findElement(By.xpath("//*[@id=\"totalcost\"]"));
        double totalPerYear = (Double.valueOf(totalPerSemes.getAttribute("value").substring(1)) * 2.0);


        double labFees = 150.0;
        totalPerYear = totalPerYear + labFees;


        // I paid $2,756.38 for this Spring 2019 semester
        double cooleysCostPerYear = 2756.38 * 2.0;
        Assert.assertEquals("Because I am taking 14 hours instead of 15 and because one of my classes has a lab fee, the calculator's estimate is $150 low.", cooleysCostPerYear, totalPerYear, 50.0);

    }

}
