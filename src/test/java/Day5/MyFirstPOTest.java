package Day5;

import Day4.BaseTest;
import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyFirstPOTest extends BaseTest {

    @Test
    public void shouldFillForm() {

/*        FormPO formPO = new FormPO(getDriver());
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
        Assert.assertEquals(textSucces, formPO.getValidationMessage());*/


        //Fluent Pattern Object
        FormFluentPO formFluentPO = new FormFluentPO(getDriver());
        formFluentPO.openMe();
        formFluentPO.fillName("Bogdan", "Wiadro")
                .fillEmail("kowalski@wp.pl")
                .chooseSex()
                .fillAge("19")
                .fillYearsOfExperience()
                .fillProfession()
                .fillContinent()
                .fillCommand()
                .chooseFile("src/main/resources/file.txt")
                .clickSaveButton();

        String textSucces = "Form send with success";
        Assert.assertEquals(formFluentPO.validation(), textSucces);
    }

    @Test
    public void shouldWaitForCompleteProgressBar() {
        ProgressBarPO progressBarPO = new ProgressBarPO(getDriver());
        progressBarPO.openMe();
        Assert.assertTrue(progressBarPO.setCompleteProgressBar());
    }

    @Test
    public void shouldWaitForAlertAndAccept() {
        AlertTestPO alertTestPO = new AlertTestPO(getDriver());
        alertTestPO.openMe();
        alertTestPO.clickDelayedAlertButton();
        alertTestPO.waitForAlertAndAccept();
        Assert.assertEquals(alertTestPO.getDelayedAlertLabelText(), "OK button pressed");
    }
}
