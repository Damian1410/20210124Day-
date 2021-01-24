import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class AlertTest extends BaseTest{

    @BeforeMethod
    public void openAlertPage(){
        getDriver().get("https://seleniumui.moderntester.pl/alerts.php");
    }

    @Test
    public void simpleAlertTest(){
        getDriver().findElement(By.id("simple-alert")).click();
        getDriver().switchTo().alert().accept();
        Assert.assertEquals(getDriver().findElement(By.id("simple-alert-label")).getText(),
                "OK button pressed" );
    }

    @Test
    public void promptAlertTest(){
        getDriver().findElement(By.id("prompt-alert")).click();
        getDriver().switchTo().alert().sendKeys("Albus Dumbledore");
        getDriver().switchTo().alert().accept();
        Assert.assertEquals(getDriver().findElement(By.id("prompt-label")).getText(),
                "Hello Albus Dumbledore! How are you today?" );
    }

}
