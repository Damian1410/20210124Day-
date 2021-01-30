package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class AlertTestPO extends BasePO {
    //click "delayed alert"
    //wait for allert
    // close alert
    //assert text

    @FindBy(id = "delayed-alert")
    private WebElement delayedAlertButton;

    @FindBy(id = "delayed-alert-label")
    private WebElement delayAlertLabel;

    public void clickDelayedAlertButton() {
        delayedAlertButton.click();
    }

    public String getDelayedAlertLabelText() {
        return delayAlertLabel.getText();
    }

    public void waitForAlertAndAccept() {
        wait.until(ExpectedConditions.alertIsPresent());
        driver.switchTo().alert().accept();
    }

    public AlertTestPO(WebDriver driver) {
        super(driver);
        ownUrl = "https://seleniumui.moderntester.pl/alerts.php";
    }
}
