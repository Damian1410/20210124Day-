package Day5;

import Day4.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstPOTest extends BaseTest {

    @Test
    public void shouldFillForm(){
        FormPO formPO = new FormPO(getDriver());
        formPO.openMe();
        formPO.fillName("Bogdan", "Wiadro");
        formPO.fillEmail("kowalski@wp.pl");
        formPO.chooseSex();
        formPO.fillAge("19");
        formPO.fillYearsOfExperience();
        formPO.fillProfession();
        formPO.fillContinent();
        formPO.fillCommand();
        formPO.chooseFile("src/main/resources/file.txt");
        formPO.clickSaveButton();

        String textSucces = "Form send with success";
        Assert.assertEquals(formPO.validation(), textSucces);
    }

    @Test
    public void shouldWaitForCompleteProgressBar(){
        ProgressBarPO progressBarPO = new ProgressBarPO(getDriver());
        progressBarPO.openMe();
        Assert.assertTrue(progressBarPO.setCompleteProgressBar());

    }
}
