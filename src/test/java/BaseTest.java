import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {
    private WebDriver driver;

    public WebDriver getDriver() {
        return driver;
    }

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver",
                "src/main/resources/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("start-maximized"); // open Browser in maximized mode
        options.addArguments("--disable-extensions"); // disabling extensions

        options.addArguments("--remote-debugging-port=9222");

         driver = new ChromeDriver(options);

    }

    @AfterMethod
    public void tearDown(){
        driver.close();

    }
}
