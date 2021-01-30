package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class BasePO {
    protected WebDriver driver;
    protected String ownUrl;
    protected WebDriverWait wait;

    public BasePO(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wait = new WebDriverWait(driver, 20);
    }

    public void openMe() {
        driver.get(ownUrl);
    }

    public int getRandomNumber(int max) {
        Random rnd = new Random();
        return rnd.nextInt(max) + 1;
    }

    public WebElement getRandomElement(List<WebElement> webElements) {
        Random rnd = new Random();
        int randomNumber = rnd.nextInt(webElements.size());
        return webElements.get(randomNumber);
    }
}
