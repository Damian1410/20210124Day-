package Day5;

import Day4.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;


public class IframesTest extends BaseTest {

    @Test
    public void iframeTest() {

        getDriver().get("https://seleniumui.moderntester.pl/iframes.php");
        getDriver().switchTo().frame("iframe1");
        WebElement firstName = getDriver().findElement(By.id("inputFirstName3"));
        firstName.sendKeys("Jan");
        WebElement lastName = getDriver().findElement(By.id("inputSurname3"));
        lastName.sendKeys("Kowalski");
        getDriver().switchTo().defaultContent();

        getDriver().switchTo().frame("iframe2");
        WebElement loginFrame = getDriver().findElement(By.id("inputLogin"));
        loginFrame.sendKeys("Jan000");
        WebElement loginPassoword = getDriver().findElement(By.id("inputPassword"));
        loginPassoword.sendKeys("haslo");

        Select kontynenty = new Select(getDriver().findElement(By.id("inlineFormCustomSelectPref")));
        kontynenty.selectByIndex(1);

        getDriver().findElement(By.id("gridRadios1")).click();

        getDriver().switchTo().parentFrame();
        getDriver().findElement(By.xpath("//a[contains(text(),'Basic')]")).click();

    }
}
