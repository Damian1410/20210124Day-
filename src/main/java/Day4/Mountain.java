package Day4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Mountain {
   private String peak;
    private String height;
    Mountain(WebElement row){
        peak = row.findElements(By.cssSelector("td")).get(0).getText();
        height = row.findElements(By.cssSelector("td")).get(3).getText();

    }

    public String getHeight() {
        return height;
    }

    public String getPeak() {
        return peak;
    }

    @Override
    public String toString() {
        return "Day4.Mountain{" +
                "peak='" + peak + '\'' +
                ", height='" + height + '\'' +
                '}';
    }
}
