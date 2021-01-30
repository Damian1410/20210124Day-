package Day5;

import Day4.BaseTest;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public class SliderTest extends BaseTest {

    @Test
    public void sliderTest() {
        getDriver().get("https://seleniumui.moderntester.pl/slider.php");
        moveTo(50);
        moveTo(80);
        moveTo(80);
        moveTo(20);

        String currentPosition = getDriver().findElement(By.id("custom-handle")).getText();
        System.out.println(currentPosition);
    }

    private int getSliderValue() {
        return Integer.parseInt(getDriver().findElement(By.id("custom-handle")).getText());

    }

    private void moveSlider(int expectedValue, Keys key) {
        while (getSliderValue() != expectedValue) {
            getDriver().findElement(By.id("custom-handle")).sendKeys(key);
        }
    }

    private void moveTo(int expectedSliderValue) {
        int actualSliderValue = getSliderValue();

        if (actualSliderValue > expectedSliderValue) {
            moveSlider(expectedSliderValue, Keys.ARROW_LEFT);
        }
        else if (actualSliderValue < expectedSliderValue) {
            moveSlider(expectedSliderValue, Keys.ARROW_RIGHT);
        }

    }
}
