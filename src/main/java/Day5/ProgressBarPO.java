package Day5;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ProgressBarPO extends BasePO {

    @FindBy(css = ".ui-progressbar-complete")
    private WebElement completeProgressBar;

    public boolean setCompleteProgressBar() {
        wait.until(ExpectedConditions.visibilityOf(completeProgressBar));
        return completeProgressBar.isDisplayed();
    }

    public ProgressBarPO(WebDriver driver) {
        super(driver);
        ownUrl = "https://seleniumui.moderntester.pl/progressbar.php";
    }
}
